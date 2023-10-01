package co.uninpahu.sight.admin.util;

import lombok.Getter;

@Getter
public enum GenericResponseCodes {

    REGISTRO_EXITOSO("001", "Registro exitoso."),
    INCONSISTENCIA_DATOS("002", "Inconsistencia en datos del registro."),
    ERROR_INTERNO_SERVIDOR("003", "Error interno en el servidor."),
    REGISTRO_FALLIDO("004", "Registro fallido."),
    CONSULTA_EXITOSA("005", "Consulta exitosa.");

    private final String value;
    private final String description;

    GenericResponseCodes(String value, String description) {
        this.value = value;
        this.description = description;
    }
}
