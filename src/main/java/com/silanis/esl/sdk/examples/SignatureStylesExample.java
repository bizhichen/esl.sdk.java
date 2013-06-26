package com.silanis.esl.sdk.examples;

import com.silanis.esl.sdk.DocumentPackage;
import com.silanis.esl.sdk.EslClient;
import com.silanis.esl.sdk.PackageId;

import static com.silanis.esl.sdk.builder.DocumentBuilder.newDocumentWithName;
import static com.silanis.esl.sdk.builder.PackageBuilder.newPackageNamed;
import static com.silanis.esl.sdk.builder.SignatureBuilder.captureFor;
import static com.silanis.esl.sdk.builder.SignatureBuilder.initialsFor;
import static com.silanis.esl.sdk.builder.SignatureBuilder.signatureFor;
import static com.silanis.esl.sdk.builder.SignerBuilder.newSignerWithEmail;

public class SignatureStylesExample {

    public static final String API_KEY = "MndYc0NhaEhib3lnOnNlY3JldA==";
    public static final String API_URL = "https://sandbox.e-signlive.com/api";

    public static void main( String... args ) {
        EslClient eslClient = new EslClient( API_KEY, API_URL );

        DocumentPackage superDuperPackage = newPackageNamed( "Sample Insurance policy" )
                .withSigner(newSignerWithEmail("etienne_hardy@silanis.com")
                        .withFirstName("John")
                        .withLastName("Smith"))
                .withDocument(newDocumentWithName("First Document")
                        .fromFile("src/main/resources/document.pdf")
                        .withSignature(signatureFor("etienne_hardy@silanis.com")
                                .onPage(0)
                                .atPosition(500, 100))
                        .withSignature(initialsFor("etienne_hardy@silanis.com")
                                .onPage(0)
                                .atPosition(500, 300))
                        .withSignature(captureFor("etienne_hardy@silanis.com")
                                .onPage(0)
                                .atPosition(500, 500)))
                .build();

        PackageId packageId = eslClient.createPackage( superDuperPackage );
        eslClient.sendPackage( packageId );
    }
}
