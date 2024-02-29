// This file connects to the spoonacular API client allowing API calls

// Import required classes
import com.spoonacular.client.ApiClient;
import com.spoonacular.client.ApiException;
import com.spoonacular.client.Configuration;
import com.spoonacular.client.auth.*;
import com.spoonacular.client.models.*;
import com.spoonacular.DefaultApi;

public class spoonAPIclient{
    public static void main(String[] args){
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.spoonacular.com");

        // API Key Authentication
        ApiKeyAuth apiKeyScheme = (ApiKeyAuth) defaultClient.getAuthentication("apiKeyScheme");
        apiKeyScheme.setApiKey("db9aec53da984d508210d9a56250751e");

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        AnalyzeRecipeRequest analyzeRecipeRequest = new AnalyzeRecipeRequest();
        String language = "en";
        Boolean includeNutrition = false;
        Boolean includeTaste = false;
        try{
            Object result = apiInstance.analyzeRecipe(analyzeRecipeRequest, language, includeNutrition, includeTaste);
            System.out.println(result);
        } catch (ApiException e){
            System.err.println("Exception when calling DefaultApi#analyzeRecipe");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }    
}
