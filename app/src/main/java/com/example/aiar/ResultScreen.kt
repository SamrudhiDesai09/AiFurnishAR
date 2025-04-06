class ResultScreen : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FurnitureAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_screen)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = FurnitureAdapter()
        recyclerView.adapter = adapter

        val resultJson = intent.getStringExtra("results_json")
        val gson = Gson()
        val response = gson.fromJson(resultJson, FurnitureResponse::class.java)

        adapter.submitList(response.results)
    }
}
