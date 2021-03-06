/*
 * BitMEX API
 * ## REST API for the BitMEX Trading Platform  [View Changelog](/app/apiChangelog)    #### Getting Started  Base URI: [https://www.bitmex.com/api/v1](/api/v1)  ##### Fetching Data  All REST endpoints are documented below. You can try out any query right from this interface.  Most table queries accept `count`, `start`, and `reverse` params. Set `reverse=true` to get rows newest-first.  Additional documentation regarding filters, timestamps, and authentication is available in [the main API documentation](/app/restAPI).  *All* table data is available via the [Websocket](/app/wsAPI). We highly recommend using the socket if you want to have the quickest possible data without being subject to ratelimits.  ##### Return Types  By default, all data is returned as JSON. Send `?_format=csv` to get CSV data or `?_format=xml` to get XML data.  ##### Trade Data Queries  *This is only a small subset of what is available, to get you started.*  Fill in the parameters and click the `Try it out!` button to try any of these queries.  * [Pricing Data](#!/Quote/Quote_get)  * [Trade Data](#!/Trade/Trade_get)  * [OrderBook Data](#!/OrderBook/OrderBook_getL2)  * [Settlement Data](#!/Settlement/Settlement_get)  * [Exchange Statistics](#!/Stats/Stats_history)  Every function of the BitMEX.com platform is exposed here and documented. Many more functions are available.  ##### Swagger Specification  [⇩ Download Swagger JSON](swagger.json)    ## All API Endpoints  Click to expand a section. 
 *
 * OpenAPI spec version: 1.2.0
 * Contact: support@bitmex.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.api;

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import io.swagger.client.model.APIKey;
import io.swagger.client.model.Error;
import io.swagger.client.model.InlineResponse200;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiKeyApi {
    private ApiClient apiClient;

    public ApiKeyApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ApiKeyApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for aPIKeyDisable
     * @param apiKeyID API Key ID (public component). (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call aPIKeyDisableCall(String apiKeyID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/apiKey/disable";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        if (apiKeyID != null)
        localVarFormParams.put("apiKeyID", apiKeyID);

        final String[] localVarAccepts = {
            "application/json", "application/xml", "text/xml", "application/javascript", "text/javascript"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json", "application/x-www-form-urlencoded"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "apiKey","apiSignature", "apiExpires" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call aPIKeyDisableValidateBeforeCall(String apiKeyID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKeyID' is set
        if (apiKeyID == null) {
            throw new ApiException("Missing the required parameter 'apiKeyID' when calling aPIKeyDisable(Async)");
        }
        

        com.squareup.okhttp.Call call = aPIKeyDisableCall(apiKeyID, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Disable an API Key.
     * 
     * @param apiKeyID API Key ID (public component). (required)
     * @return APIKey
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public APIKey aPIKeyDisable(String apiKeyID) throws ApiException {
        ApiResponse<APIKey> resp = aPIKeyDisableWithHttpInfo(apiKeyID);
        return resp.getData();
    }

    /**
     * Disable an API Key.
     * 
     * @param apiKeyID API Key ID (public component). (required)
     * @return ApiResponse&lt;APIKey&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<APIKey> aPIKeyDisableWithHttpInfo(String apiKeyID) throws ApiException {
        com.squareup.okhttp.Call call = aPIKeyDisableValidateBeforeCall(apiKeyID, null, null);
        Type localVarReturnType = new TypeToken<APIKey>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Disable an API Key. (asynchronously)
     * 
     * @param apiKeyID API Key ID (public component). (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call aPIKeyDisableAsync(String apiKeyID, final ApiCallback<APIKey> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = aPIKeyDisableValidateBeforeCall(apiKeyID, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<APIKey>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for aPIKeyEnable
     * @param apiKeyID API Key ID (public component). (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call aPIKeyEnableCall(String apiKeyID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/apiKey/enable";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        if (apiKeyID != null)
        localVarFormParams.put("apiKeyID", apiKeyID);

        final String[] localVarAccepts = {
            "application/json", "application/xml", "text/xml", "application/javascript", "text/javascript"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json", "application/x-www-form-urlencoded"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "apiKey","apiSignature", "apiExpires" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call aPIKeyEnableValidateBeforeCall(String apiKeyID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKeyID' is set
        if (apiKeyID == null) {
            throw new ApiException("Missing the required parameter 'apiKeyID' when calling aPIKeyEnable(Async)");
        }
        

        com.squareup.okhttp.Call call = aPIKeyEnableCall(apiKeyID, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Enable an API Key.
     * 
     * @param apiKeyID API Key ID (public component). (required)
     * @return APIKey
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public APIKey aPIKeyEnable(String apiKeyID) throws ApiException {
        ApiResponse<APIKey> resp = aPIKeyEnableWithHttpInfo(apiKeyID);
        return resp.getData();
    }

    /**
     * Enable an API Key.
     * 
     * @param apiKeyID API Key ID (public component). (required)
     * @return ApiResponse&lt;APIKey&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<APIKey> aPIKeyEnableWithHttpInfo(String apiKeyID) throws ApiException {
        com.squareup.okhttp.Call call = aPIKeyEnableValidateBeforeCall(apiKeyID, null, null);
        Type localVarReturnType = new TypeToken<APIKey>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Enable an API Key. (asynchronously)
     * 
     * @param apiKeyID API Key ID (public component). (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call aPIKeyEnableAsync(String apiKeyID, final ApiCallback<APIKey> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = aPIKeyEnableValidateBeforeCall(apiKeyID, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<APIKey>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for aPIKeyGet
     * @param reverse If true, will sort results newest first. (optional, default to false)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call aPIKeyGetCall(Boolean reverse, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/apiKey";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (reverse != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("reverse", reverse));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "application/xml", "text/xml", "application/javascript", "text/javascript"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json", "application/x-www-form-urlencoded"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "apiKey","apiSignature", "apiExpires" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call aPIKeyGetValidateBeforeCall(Boolean reverse, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = aPIKeyGetCall(reverse, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get your API Keys.
     * 
     * @param reverse If true, will sort results newest first. (optional, default to false)
     * @return List&lt;APIKey&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<APIKey> aPIKeyGet(Boolean reverse) throws ApiException {
        ApiResponse<List<APIKey>> resp = aPIKeyGetWithHttpInfo(reverse);
        return resp.getData();
    }

    /**
     * Get your API Keys.
     * 
     * @param reverse If true, will sort results newest first. (optional, default to false)
     * @return ApiResponse&lt;List&lt;APIKey&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<APIKey>> aPIKeyGetWithHttpInfo(Boolean reverse) throws ApiException {
        com.squareup.okhttp.Call call = aPIKeyGetValidateBeforeCall(reverse, null, null);
        Type localVarReturnType = new TypeToken<List<APIKey>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get your API Keys. (asynchronously)
     * 
     * @param reverse If true, will sort results newest first. (optional, default to false)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call aPIKeyGetAsync(Boolean reverse, final ApiCallback<List<APIKey>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = aPIKeyGetValidateBeforeCall(reverse, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<APIKey>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for aPIKeyNew
     * @param name Key name. This name is for reference only. (optional)
     * @param cidr CIDR block to restrict this key to. To restrict to a single address, append \&quot;/32\&quot;, e.g. 207.39.29.22/32. Leave blank or set to 0.0.0.0/0 to allow all IPs. Only one block may be set. &lt;a href&#x3D;\&quot;http://software77.net/cidr-101.html\&quot;&gt;More on CIDR blocks&lt;/a&gt; (optional)
     * @param permissions Key Permissions. All keys can read margin and position data. Additional permissions must be added. Available: [\&quot;order\&quot;, \&quot;orderCancel\&quot;, \&quot;withdraw\&quot;]. (optional)
     * @param enabled Set to true to enable this key on creation. Otherwise, it must be explicitly enabled via /apiKey/enable. (optional, default to false)
     * @param token OTP Token (YubiKey, Google Authenticator) (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call aPIKeyNewCall(String name, String cidr, String permissions, Boolean enabled, String token, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/apiKey";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        if (name != null)
        localVarFormParams.put("name", name);
        if (cidr != null)
        localVarFormParams.put("cidr", cidr);
        if (permissions != null)
        localVarFormParams.put("permissions", permissions);
        if (enabled != null)
        localVarFormParams.put("enabled", enabled);
        if (token != null)
        localVarFormParams.put("token", token);

        final String[] localVarAccepts = {
            "application/json", "application/xml", "text/xml", "application/javascript", "text/javascript"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json", "application/x-www-form-urlencoded"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "apiKey","apiSignature", "apiExpires" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call aPIKeyNewValidateBeforeCall(String name, String cidr, String permissions, Boolean enabled, String token, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = aPIKeyNewCall(name, cidr, permissions, enabled, token, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Create a new API Key.
     * API Keys can only be created via the frontend.
     * @param name Key name. This name is for reference only. (optional)
     * @param cidr CIDR block to restrict this key to. To restrict to a single address, append \&quot;/32\&quot;, e.g. 207.39.29.22/32. Leave blank or set to 0.0.0.0/0 to allow all IPs. Only one block may be set. &lt;a href&#x3D;\&quot;http://software77.net/cidr-101.html\&quot;&gt;More on CIDR blocks&lt;/a&gt; (optional)
     * @param permissions Key Permissions. All keys can read margin and position data. Additional permissions must be added. Available: [\&quot;order\&quot;, \&quot;orderCancel\&quot;, \&quot;withdraw\&quot;]. (optional)
     * @param enabled Set to true to enable this key on creation. Otherwise, it must be explicitly enabled via /apiKey/enable. (optional, default to false)
     * @param token OTP Token (YubiKey, Google Authenticator) (optional)
     * @return APIKey
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public APIKey aPIKeyNew(String name, String cidr, String permissions, Boolean enabled, String token) throws ApiException {
        ApiResponse<APIKey> resp = aPIKeyNewWithHttpInfo(name, cidr, permissions, enabled, token);
        return resp.getData();
    }

    /**
     * Create a new API Key.
     * API Keys can only be created via the frontend.
     * @param name Key name. This name is for reference only. (optional)
     * @param cidr CIDR block to restrict this key to. To restrict to a single address, append \&quot;/32\&quot;, e.g. 207.39.29.22/32. Leave blank or set to 0.0.0.0/0 to allow all IPs. Only one block may be set. &lt;a href&#x3D;\&quot;http://software77.net/cidr-101.html\&quot;&gt;More on CIDR blocks&lt;/a&gt; (optional)
     * @param permissions Key Permissions. All keys can read margin and position data. Additional permissions must be added. Available: [\&quot;order\&quot;, \&quot;orderCancel\&quot;, \&quot;withdraw\&quot;]. (optional)
     * @param enabled Set to true to enable this key on creation. Otherwise, it must be explicitly enabled via /apiKey/enable. (optional, default to false)
     * @param token OTP Token (YubiKey, Google Authenticator) (optional)
     * @return ApiResponse&lt;APIKey&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<APIKey> aPIKeyNewWithHttpInfo(String name, String cidr, String permissions, Boolean enabled, String token) throws ApiException {
        com.squareup.okhttp.Call call = aPIKeyNewValidateBeforeCall(name, cidr, permissions, enabled, token, null, null);
        Type localVarReturnType = new TypeToken<APIKey>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create a new API Key. (asynchronously)
     * API Keys can only be created via the frontend.
     * @param name Key name. This name is for reference only. (optional)
     * @param cidr CIDR block to restrict this key to. To restrict to a single address, append \&quot;/32\&quot;, e.g. 207.39.29.22/32. Leave blank or set to 0.0.0.0/0 to allow all IPs. Only one block may be set. &lt;a href&#x3D;\&quot;http://software77.net/cidr-101.html\&quot;&gt;More on CIDR blocks&lt;/a&gt; (optional)
     * @param permissions Key Permissions. All keys can read margin and position data. Additional permissions must be added. Available: [\&quot;order\&quot;, \&quot;orderCancel\&quot;, \&quot;withdraw\&quot;]. (optional)
     * @param enabled Set to true to enable this key on creation. Otherwise, it must be explicitly enabled via /apiKey/enable. (optional, default to false)
     * @param token OTP Token (YubiKey, Google Authenticator) (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call aPIKeyNewAsync(String name, String cidr, String permissions, Boolean enabled, String token, final ApiCallback<APIKey> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = aPIKeyNewValidateBeforeCall(name, cidr, permissions, enabled, token, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<APIKey>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for aPIKeyRemove
     * @param apiKeyID API Key ID (public component). (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call aPIKeyRemoveCall(String apiKeyID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/apiKey";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        if (apiKeyID != null)
        localVarFormParams.put("apiKeyID", apiKeyID);

        final String[] localVarAccepts = {
            "application/json", "application/xml", "text/xml", "application/javascript", "text/javascript"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json", "application/x-www-form-urlencoded"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "apiKey","apiSignature", "apiExpires"};
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call aPIKeyRemoveValidateBeforeCall(String apiKeyID, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiKeyID' is set
        if (apiKeyID == null) {
            throw new ApiException("Missing the required parameter 'apiKeyID' when calling aPIKeyRemove(Async)");
        }
        

        com.squareup.okhttp.Call call = aPIKeyRemoveCall(apiKeyID, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Remove an API Key.
     * 
     * @param apiKeyID API Key ID (public component). (required)
     * @return InlineResponse200
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public InlineResponse200 aPIKeyRemove(String apiKeyID) throws ApiException {
        ApiResponse<InlineResponse200> resp = aPIKeyRemoveWithHttpInfo(apiKeyID);
        return resp.getData();
    }

    /**
     * Remove an API Key.
     * 
     * @param apiKeyID API Key ID (public component). (required)
     * @return ApiResponse&lt;InlineResponse200&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<InlineResponse200> aPIKeyRemoveWithHttpInfo(String apiKeyID) throws ApiException {
        com.squareup.okhttp.Call call = aPIKeyRemoveValidateBeforeCall(apiKeyID, null, null);
        Type localVarReturnType = new TypeToken<InlineResponse200>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Remove an API Key. (asynchronously)
     * 
     * @param apiKeyID API Key ID (public component). (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call aPIKeyRemoveAsync(String apiKeyID, final ApiCallback<InlineResponse200> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = aPIKeyRemoveValidateBeforeCall(apiKeyID, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<InlineResponse200>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
