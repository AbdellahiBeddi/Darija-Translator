package ma.translator;

import jakarta.ws.rs.container.*;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.core.*;
import java.util.Base64;

@Provider
@PreMatching
public class BasicAuthFilter implements ContainerRequestFilter {

    private static final String USER = "admin";
    private static final String PASS = "admin123";

    @Override
    public void filter(ContainerRequestContext ctx) {
        String auth = ctx.getHeaderString("Authorization");
        if (auth == null || !auth.startsWith("Basic ")) {
            abort(ctx); return;
        }
        String decoded = new String(Base64.getDecoder().decode(auth.substring(6)));
        String[] parts = decoded.split(":", 2);
        if (parts.length != 2 || !parts[0].equals(USER) || !parts[1].equals(PASS)) {
            abort(ctx);
        }
    }

    private void abort(ContainerRequestContext ctx) {
        ctx.abortWith(Response.status(Response.Status.UNAUTHORIZED)
            .header("WWW-Authenticate", "Basic realm=\"Translator\"")
            .build());
    }
}