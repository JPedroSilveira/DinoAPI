package br.ufrgs.inf.pet.dinoapi.communication.google;

import br.ufrgs.inf.pet.dinoapi.enumerable.GoogleScopesEnum;
import br.ufrgs.inf.pet.dinoapi.service.auth.google.GoogleAuthServiceImpl;
import com.google.api.client.googleapis.auth.oauth2.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.ArrayList;

/**
 * Implementação de: {@link GoogleAPICommunication}
 *
 * @author joao.silva
 */
public class GoogleAPICommunicationImpl implements GoogleAPICommunication {

    @Autowired
    GoogleAuthServiceImpl googleAuthService;

    private String REDIRECT_URI = "http://localhost:3000";

    public GoogleTokenResponse getGoogleToken(String token) {
        try {
            GoogleClientSecrets clientSecrets = getClientSecrets();

            ArrayList<String> scopes = new ArrayList<>();

            scopes.add(GoogleScopesEnum.CALENDAR.getScope());
            scopes.add(GoogleScopesEnum.PROFILE.getScope());

            GoogleTokenResponse tokenResponse =
                    new GoogleAuthorizationCodeTokenRequest(
                            new NetHttpTransport(),
                            JacksonFactory.getDefaultInstance(),
                            "https://oauth2.googleapis.com/token",
                            clientSecrets.getDetails().getClientId(),
                            clientSecrets.getDetails().getClientSecret(),
                            token,
                            REDIRECT_URI)   // Specify the same redirect URI that you use with your web
                                            // app. If you don't have a web version of your app, you can
                                            // specify an empty string.
                            .setScopes(scopes)
                            .execute();

            return tokenResponse;
        } catch (IOException ex) {
            //TO-DO Tratar erro
            ex.printStackTrace();
        }

        //TO-DO Tratar erro
        return null;
    }

    public GoogleTokenResponse refreshAccessToken(String refreshToken) {
        ArrayList<String> scopes = new ArrayList<>();

        scopes.add(GoogleScopesEnum.CALENDAR.getScope());

        GoogleTokenResponse tokenResponse = null;
        try {
            GoogleClientSecrets secrets = getClientSecrets();

            tokenResponse = new GoogleRefreshTokenRequest(
                    new NetHttpTransport(),
                    JacksonFactory.getDefaultInstance(),
                    refreshToken,
                    secrets.getDetails().getClientId(),
                    secrets.getDetails().getClientSecret())
                    .setScopes(scopes)
                    .setGrantType("refresh_token")
                    .execute();

            return tokenResponse;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private GoogleClientSecrets getClientSecrets() throws IOException {
        String googleSecret = new String(
                Files.readAllBytes(
                        new File(
                                getClass().getClassLoader().getResource("client_secret.json").getFile()
                        ).toPath()
                )
        );
        return GoogleClientSecrets.load(JacksonFactory.getDefaultInstance(), new StringReader(googleSecret));
    }

}
