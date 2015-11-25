package data;

import data.Assetentity;
import data.Attribute;
import data.Attributetype;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-25T22:10:52")
@StaticMetamodel(Attribute.class)
public class Attribute_ { 

    public static volatile SingularAttribute<Attribute, Short> showonchild;
    public static volatile SingularAttribute<Attribute, String> searchhelptext;
    public static volatile SingularAttribute<Attribute, String> pluginparamsattributeids;
    public static volatile SingularAttribute<Attribute, Short> includeinsearchforchild;
    public static volatile SingularAttribute<Attribute, Attribute> parentid;
    public static volatile CollectionAttribute<Attribute, Assetentity> assetentityCollection;
    public static volatile SingularAttribute<Attribute, Short> ismandatorybulkupload;
    public static volatile SingularAttribute<Attribute, Short> highlight;
    public static volatile SingularAttribute<Attribute, Short> requirestranslation;
    public static volatile SingularAttribute<Attribute, String> valuecolumnname;
    public static volatile SingularAttribute<Attribute, Integer> incrementamount;
    public static volatile SingularAttribute<Attribute, Short> isrequiredforcompleteness;
    public static volatile SingularAttribute<Attribute, Integer> height;
    public static volatile SingularAttribute<Attribute, Short> isdescriptionattribute;
    public static volatile SingularAttribute<Attribute, Short> isautocomplete;
    public static volatile CollectionAttribute<Attribute, Attribute> attributeCollection;
    public static volatile SingularAttribute<Attribute, Integer> width;
    public static volatile SingularAttribute<Attribute, Short> enforceuniqueness;
    public static volatile SingularAttribute<Attribute, Short> showondownload;
    public static volatile SingularAttribute<Attribute, Short> nameattribute;
    public static volatile SingularAttribute<Attribute, String> label;
    public static volatile SingularAttribute<Attribute, Integer> mindecimalplaces;
    public static volatile SingularAttribute<Attribute, String> inputmask;
    public static volatile SingularAttribute<Attribute, Short> isextendablelist;
    public static volatile SingularAttribute<Attribute, Short> isreadonly;
    public static volatile SingularAttribute<Attribute, String> staticfieldname;
    public static volatile SingularAttribute<Attribute, Short> sanitizehtml;
    public static volatile SingularAttribute<Attribute, String> prefix;
    public static volatile SingularAttribute<Attribute, String> baseurl;
    public static volatile SingularAttribute<Attribute, Short> isstatic;
    public static volatile SingularAttribute<Attribute, Short> hideforsort;
    public static volatile SingularAttribute<Attribute, Short> hassearchtokens;
    public static volatile SingularAttribute<Attribute, String> pluginclass;
    public static volatile SingularAttribute<Attribute, String> tokendelimiterregex;
    public static volatile SingularAttribute<Attribute, String> onchangescript;
    public static volatile SingularAttribute<Attribute, Short> isfiltered;
    public static volatile SingularAttribute<Attribute, Attributetype> attributetypeid;
    public static volatile SingularAttribute<Attribute, Integer> id;
    public static volatile SingularAttribute<Attribute, String> defaultkeywordfilter;
    public static volatile SingularAttribute<Attribute, Integer> maxdisplaylength;
    public static volatile SingularAttribute<Attribute, Integer> maxsize;
    public static volatile SingularAttribute<Attribute, Short> singlepointonly;
    public static volatile SingularAttribute<Attribute, String> keywordimporturl;
    public static volatile SingularAttribute<Attribute, Short> ismandatory;
    public static volatile SingularAttribute<Attribute, String> defaultvalue;
    public static volatile SingularAttribute<Attribute, String> helptext;
    public static volatile SingularAttribute<Attribute, Short> ishtml;
    public static volatile SingularAttribute<Attribute, Integer> seed;
    public static volatile SingularAttribute<Attribute, Short> iskeywordsearchable;
    public static volatile SingularAttribute<Attribute, Short> getdatafromchildren;
    public static volatile SingularAttribute<Attribute, String> alttext;
    public static volatile SingularAttribute<Attribute, Short> fulldateprecisionrequired;
    public static volatile SingularAttribute<Attribute, Short> dateformattype;
    public static volatile SingularAttribute<Attribute, Integer> maxdecimalplaces;
    public static volatile SingularAttribute<Attribute, String> valueifnotvisible;
    public static volatile SingularAttribute<Attribute, String> autocompleteplugin;
    public static volatile SingularAttribute<Attribute, String> displayname;
    public static volatile SingularAttribute<Attribute, Integer> treeid;

}