package org.bouncycastle.cms;

import java.util.Date;
import java.util.Hashtable;
import java.util.Map;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.cms.Attribute;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.cms.CMSAttributes;
import org.bouncycastle.asn1.cms.Time;

public class DefaultSignedAttributeTableGenerator implements CMSAttributeTableGenerator {
    private final Hashtable table;

    public DefaultSignedAttributeTableGenerator() {
        this.table = new Hashtable();
    }

    public DefaultSignedAttributeTableGenerator(AttributeTable attributeTable) {
        this.table = attributeTable != null ? attributeTable.toHashtable() : new Hashtable();
    }

    /* access modifiers changed from: protected */
    public Hashtable createStandardAttributeTable(Map map) {
        DERObjectIdentifier dERObjectIdentifier;
        Hashtable hashtable = (Hashtable) this.table.clone();
        if (!hashtable.containsKey(CMSAttributes.contentType) && (dERObjectIdentifier = (DERObjectIdentifier) map.get(CMSAttributeTableGenerator.CONTENT_TYPE)) != null) {
            Attribute attribute = new Attribute(CMSAttributes.contentType, new DERSet(dERObjectIdentifier));
            hashtable.put(attribute.getAttrType(), attribute);
        }
        if (!hashtable.containsKey(CMSAttributes.signingTime)) {
            Attribute attribute2 = new Attribute(CMSAttributes.signingTime, new DERSet(new Time(new Date())));
            hashtable.put(attribute2.getAttrType(), attribute2);
        }
        if (!hashtable.containsKey(CMSAttributes.messageDigest)) {
            Attribute attribute3 = new Attribute(CMSAttributes.messageDigest, new DERSet(new DEROctetString((byte[]) map.get(CMSAttributeTableGenerator.DIGEST))));
            hashtable.put(attribute3.getAttrType(), attribute3);
        }
        return hashtable;
    }

    @Override // org.bouncycastle.cms.CMSAttributeTableGenerator
    public AttributeTable getAttributes(Map map) {
        return new AttributeTable(createStandardAttributeTable(map));
    }
}
