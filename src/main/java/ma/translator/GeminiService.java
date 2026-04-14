package ma.translator;

import java.net.http.*;
import java.net.URI;

public class GeminiService {

    private static final String API_KEY = "AIzaSyDu4GOg1M0Dmbsw9SXp9umlH6ZhyQLn58Q";
    private static final String URL =
        "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=" + API_KEY;

    public static String translate(String text, String src, String tgt) throws Exception {
        String prompt = "Translate from " + src + " to " + tgt +
                        " (Moroccan Darija). Return ONLY the translation.\nText: " + text;

        String body = """
            {"contents": [{"parts": [{"text": "%s"}]}]}
            """.formatted(prompt.replace("\"", "\\\""));

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder()
            .uri(URI.create(URL))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(body))
            .build();

        HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());

        String resp = res.body();
        int start = resp.indexOf("\"text\": \"") + 9;
        int end   = resp.indexOf("\"", start);
        return resp.substring(start, end);
    }
}