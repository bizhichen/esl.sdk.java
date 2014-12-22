package com.silanis.esl.sdk;

import com.silanis.esl.sdk.internal.converter.EslEnumeration;

import java.util.HashMap;
import java.util.Map;

public class FieldStyle extends EslEnumeration {

    public static final FieldStyle BOUND_DATE = new FieldStyle("LABEL", "BOUND_DATE", "{approval.signed}");
    public static final FieldStyle BOUND_NAME = new FieldStyle("LABEL", "BOUND_NAME", "{signer.name}");
    public static final FieldStyle BOUND_TITLE = new FieldStyle("LABEL", "BOUND_TITLE", "{signer.title}");
    public static final FieldStyle BOUND_COMPANY = new FieldStyle("LABEL", "BOUND_COMPANY", "{signer.company}");
    public static final FieldStyle BOUND_QRCODE = new FieldStyle("QRCODE", "BOUND_QRCODE");
    public static final FieldStyle UNBOUND_TEXT_FIELD = new FieldStyle("TEXTFIELD", "UNBOUND_TEXT_FIELD");
    public static final FieldStyle UNBOUND_CUSTOM_FIELD = new FieldStyle("CUSTOMFIELD", "UNBOUND_CUSTOM_FIELD");
    public static final FieldStyle UNBOUND_CHECK_BOX = new FieldStyle("CHECKBOX", "UNBOUND_CHECK_BOX");
    public static final FieldStyle UNBOUND_RADIO_BUTTON = new FieldStyle("RADIO", "UNBOUND_RADIO_BUTTON");
    public static final FieldStyle LABEL = new FieldStyle("LABEL", "LABEL");
    public static final FieldStyle DROP_LIST = new FieldStyle("LIST", "DROP_LIST");
    public static final FieldStyle TEXT_AREA = new FieldStyle("TEXTAREA", "TEXT_AREA");
    public static final FieldStyle SEAL = new FieldStyle("SEAL", "SEAL");

    /**
     * DO NOT USE! This is an internal implementation concern. It is there to avoid crashes in existing code when new values are added to the enumerations
     * by new versions of e-SignLive. If you need access to those new values, you should upgrade your SDK version.
     * @deprecated Please upgrade your SDK version to support new types in this enumeration.
     */
    @Deprecated
    public static final FieldStyle UNRECOGNIZED(String unknownValue){
        log.warning(String.format("Unknown API FieldSubtype(%s). The upgrade is required.", unknownValue));
        return new FieldStyle(unknownValue, unknownValue);
    }

    private static Map<String, FieldStyle> sdkValues;
    static {
        sdkValues = new HashMap<String, FieldStyle>();
        sdkValues.put(BOUND_QRCODE.name(), BOUND_QRCODE);
        sdkValues.put(UNBOUND_TEXT_FIELD.name(), UNBOUND_TEXT_FIELD);
        sdkValues.put(UNBOUND_CUSTOM_FIELD.name(), UNBOUND_CUSTOM_FIELD);
        sdkValues.put(UNBOUND_CHECK_BOX.name(), UNBOUND_CHECK_BOX);
        sdkValues.put(UNBOUND_RADIO_BUTTON.name(), UNBOUND_RADIO_BUTTON);
        sdkValues.put(LABEL.name(), LABEL);
        sdkValues.put(DROP_LIST.name(), DROP_LIST);
        sdkValues.put(TEXT_AREA.name(), TEXT_AREA);
        sdkValues.put(SEAL.name(), SEAL);
    }

    private final String binding;

    private FieldStyle(String apiValue, String sdkValue) {
        this(apiValue, sdkValue, null);
    }

    private FieldStyle(String apiValue, String sdkValue, String binding) {
        super(apiValue, sdkValue);
        this.binding = binding;
    }

    public String getBinding() {
        return binding;
    }

    public static FieldStyle[] values() {
        return sdkValues.values().toArray(new FieldStyle[sdkValues.size()]);
    }

    public static FieldStyle valueOf(String name) {
        FieldStyle result = sdkValues.get(name);
        if (result != null)
            return result;
        if (name == null)
            throw new NullPointerException("Name is null");
        throw new IllegalArgumentException("No enum const FieldStyle." + name);
    }

}