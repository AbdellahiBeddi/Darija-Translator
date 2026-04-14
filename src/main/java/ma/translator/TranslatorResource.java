package ma.translator;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("/translate")
public class TranslatorResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response translate(TranslationRequest req) throws Exception {
        String translated = GeminiService.translate(req.text, req.sourceLang, req.targetLang);
        return Response.ok("{\"translation\": \"" + translated + "\"}").build();
    }

    public static class TranslationRequest {
        public String text;
        public String sourceLang;
        public String targetLang;
    }
}