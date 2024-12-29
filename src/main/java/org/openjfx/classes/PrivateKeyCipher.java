package org.openfx.classes;

class PrivateKeyCipher {

    private char[] PBEalg;

    private byte[] encodedPrivKey;
    private char[] password;

    public PrivateKeyCipher(byte[] encodedPrivKey, char[] password) {
        this.encodedPrivKey = encodedPrivKey;
    }

    
    
}