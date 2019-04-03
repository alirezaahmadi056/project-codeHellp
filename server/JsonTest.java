public class MainActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TextView output = (TextView) findViewById(R.id.textView1);
		String strJson="
		{
			\"Employee\" :[
			{
				\"id\":\"01\",
				\"name\":\"Gopal Varma\",
				\"salary\":\"500000\"
			},
			{
				\"id\":\"02\",
				\"name\":\"Sairamkrishna\",
				\"salary\":\"500000\"
			},
			{
				\"id\":\"03\",
				\"name\":\"Sathish kallakuri\",
				\"salary\":\"600000\"
			}
			]
		}";

		String data = "";
		try {
			JSONObject jsonRootObject = new JSONObject(strJson);

			//Get the instance of JSONArray that contains JSONObjects
			JSONArray jsonArray = jsonRootObject.optJSONArray("Employee");

			//Iterate the jsonArray and print the info of JSONObjects
			for(int i=0; i < jsonArray.length(); i++){
				JSONObject JSONObject = jsonArray.getJSONObject(i);

				in id = Integer.parseInt(jsonObject.optString("id").toString());
				String name = jsonObject.optString("name").toString();
				float salary = Float.parseFloat(jsonObject.optString("salary").toString());

				data += "Node"+i+" : \n id= "+ id +" \n Name= "+ name +" \n Salary= "+ salary +" \n";
			}
			output.setText(data);
		} catch (JSONException e ) { e printStackTrace();}
	}
}