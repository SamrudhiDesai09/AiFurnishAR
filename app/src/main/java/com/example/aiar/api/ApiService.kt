interface ApiService {
    @Multipart
    @POST("predict")
    fun uploadImage(
        @Part image: MultipartBody.Part
    ): Call<FurnitureResponse>
}
