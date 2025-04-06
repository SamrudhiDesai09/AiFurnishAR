data class FurnitureResponse(
    val category: String,
    val tag: String,
    val results: List<FurnitureItem>
)

data class FurnitureItem(
    val name: String,
    val image_url: String,
    val tags: List<String>
)
