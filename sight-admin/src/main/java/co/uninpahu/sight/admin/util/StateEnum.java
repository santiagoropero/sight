package co.uninpahu.sight.admin.util;

public enum StateEnum {
    ACTIVO,
    INACTIVO;

    public static StateEnum fromValue(String v) {
        return valueOf(v);
    }
}
