from flask import Flask, request, jsonify
from flask_cors import CORS
from PIL import Image
import tensorflow as tf
import numpy as np
import supabase

# Supabase
SUPABASE_URL = "https://vjjccowcihzsfomzkvug.supabase.co"
SUPABASE_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InZqamNjb3djaWh6c2ZvbXprdnVnIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDM5MjIyNjYsImV4cCI6MjA1OTQ5ODI2Nn0.oZi4C16t1wk8UpLG1kZel3yL4kNKt2Qk-BjhfnejKUA"

sb = supabase.create_client(SUPABASE_URL, SUPABASE_KEY)

# Load model
model = tf.keras.models.load_model("model/furniture_model.h5")
class_names = ['Bed', 'Chair', 'Sofa', 'Table']  # update as needed

app = Flask(__name__)
CORS(app)

def preprocess_image(img):
    img = img.resize((128, 128))
    img = np.array(img) / 255.0
    return np.expand_dims(img, axis=0)

def get_contrast_color(predicted_class):
    contrast_map = {
        "black": "white", "white": "black",
        "brown": "cream", "blue": "yellow",
        "green": "pink"  # etc.
    }
    return contrast_map.get(predicted_class.lower(), "modern")

@app.route('/predict', methods=['POST'])
def predict():
    file = request.files['image']
    img = Image.open(file.stream).convert("RGB")

    input_img = preprocess_image(img)
    prediction = model.predict(input_img)
    predicted_index = np.argmax(prediction)
    predicted_category = class_names[predicted_index]

    # Get contrasting tag
    contrast_tag = get_contrast_color(predicted_category)

    # Query Supabase
    response = sb.table("furniture").select("*").eq("category", predicted_category).contains("tags", [contrast_tag]).execute()
    results = response.data

    return jsonify({
        "category": predicted_category,
        "tag": contrast_tag,
        "results": results
    })

if __name__ == "__main__":
    app.run(debug=True)
