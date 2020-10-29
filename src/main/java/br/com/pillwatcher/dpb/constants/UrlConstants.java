package br.com.pillwatcher.dpb.constants;

public final class UrlConstants {

    public static final String BASE_URI = "/v1/pillwatcher";
    public static final String URI_NURSES = BASE_URI + "/nurses";
    public static final String URI_NURSES_CPF = URI_NURSES + "/{cpf}";

    private UrlConstants() {
    }
}
