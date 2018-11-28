/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracion.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
//import com.lowagie.text.DocumentException;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;
import java.security.cert.CertificateException;


/**
 *
 * @author Admin
 */
public class TorreApi {
    
InputStream inputStream = null;
OutputStream outputStream = null;


    public static String consultarTorre(String url,String tipo) throws MalformedURLException, IOException {

        InputStream inputStream = null;
        InputStream inputStreamerror = null;
        final String username = "";
        final String password = "";
        String cadena = Integer.toString(username.length()) + "|" + username + ":" + password;

        URL urlnew = new URL(url);

        System.out.println("paso url " + url);
        trustAllHosts();
        HttpsURLConnection urlConnection = (HttpsURLConnection) urlnew.openConnection();
        String line = "";
        String result = "";
        byte[] buf = new byte[4096];
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            String basicAuth = "Basic " + new String(Base64.encode(cadena.getBytes()));

            System.out.println("paso conexion");
            urlConnection.setRequestMethod(tipo);
            urlConnection.setRequestProperty("authorization", basicAuth);
            System.out.println("paso setrequet");

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (urlConnection.getInputStream())));

            System.out.println("paso inputstream");
            //     result = convertInputStreamToString(inputStream);
            while ((line = br.readLine()) != null) {
                result += line;
            }

            System.out.println("Respuesta  " + Integer.toString(result.length()) + " - " + result);
        } catch (IOException e) {
            try {
result = "err";
                System.out.println("entro al error " + e.getMessage());
                int respCode = urlConnection.getResponseCode();
                InputStream es = urlConnection.getErrorStream();
                int ret = 0;
                // read the response body
                while ((ret = es.read(buf)) > 0) {
                    os.write(buf, 0, ret);
                }
                // close the errorstream
                es.close();
                System.out.println("Error response " + respCode + ": "
                        + new String(os.toByteArray()));
            } catch (IOException ex) {
                System.out.println("Error FinAL");
            }
        }
        urlConnection.disconnect();
        /*
         urlConnection.setRequestMethod("GET");
         inputStream = new BufferedInputStream(urlConnection.getInputStream());
         result = convertInputStreamToString(inputStream);
         System.out.println(result);
         */
        return result;
    }

    
    private static void trustAllHosts() {

        X509TrustManager easyTrustManager = new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] xcs, String string) 
                    throws CertificateException {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void checkServerTrusted(X509Certificate[] xcs, String string) 
                    throws CertificateException {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }


        };

        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[]{(TrustManager) easyTrustManager};

        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("SSL");

            sc.init(null, trustAllCerts, new java.security.SecureRandom());

            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en trustAllHosts");
        }

        HostnameVerifier allHostsValid = new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                // TODO Auto-generated method stub
                return true;
            }
        };

        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
    }

}