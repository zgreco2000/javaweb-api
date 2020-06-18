package ar.com.educacionit.app.ws.wsrest.client;

public abstract class RestRecuestExecutor<T> {

	protected String urlRestApi;
	
	public RestRecuestExecutor (String urlRestApi) {
		this.urlRestApi = urlRestApi;
		
		public T executeRestCall() throws Exception{
			
			
		}
		
	}
}
