class AiRecommendationActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var uploadButton: Button
    private val imageRequestCode = 100
    private var selectedImageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ai_recommendation)

        imageView = findViewById(R.id.imageView)
        uploadButton = findViewById(R.id.btnUpload)

        imageView.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, imageRequestCode)
        }

        uploadButton.setOnClickListener {
            selectedImageUri?.let { uri ->
                uploadImage(uri)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == imageRequestCode && resultCode == RESULT_OK) {
            selectedImageUri = data?.data
            imageView.setImageURI(selectedImageUri)
        }
    }

    private fun uploadImage(uri: Uri) {
        val file = File(getRealPathFromURI(uri))
        val requestFile = RequestBody.create("image/*".toMediaTypeOrNull(), file)
        val body = MultipartBody.Part.createFormData("image", file.name, requestFile)

        RetrofitClient.instance.uploadImage(body).enqueue(object : Callback<FurnitureResponse> {
            override fun onResponse(call: Call<FurnitureResponse>, response: Response<FurnitureResponse>) {
                if (response.isSuccessful) {
                    val intent = Intent(this@AiRecommendationActivity, ResultScreen::class.java)
                    val gson = Gson()
                    val json = gson.toJson(response.body())
                    intent.putExtra("results_json", json)
                    startActivity(intent)
                }
            }

            override fun onFailure(call: Call<FurnitureResponse>, t: Throwable) {
                Toast.makeText(this@AiRecommendationActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun getRealPathFromURI(uri: Uri): String {
        val cursor = contentResolver.query(uri, null, null, null, null)
        cursor?.moveToFirst()
        val idx = cursor?.getColumnIndex(MediaStore.Images.ImageColumns.DATA)
        val path = cursor?.getString(idx ?: 0) ?: ""
        cursor?.close()
        return path
    }
}
