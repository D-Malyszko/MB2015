package data;

import data.Asset;
import data.Assettype;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-30T17:12:50")
@StaticMetamodel(Fileformat.class)
public class Fileformat_ { 

    public static volatile SingularAttribute<Fileformat, String> totextconverterclass;
    public static volatile SingularAttribute<Fileformat, Integer> previewheight;
    public static volatile SingularAttribute<Fileformat, Short> convertindividuallayers;
    public static volatile SingularAttribute<Fileformat, Short> isconversiontarget;
    public static volatile SingularAttribute<Fileformat, Short> supportstransparency;
    public static volatile SingularAttribute<Fileformat, Short> isrotatable;
    public static volatile SingularAttribute<Fileformat, String> viewfileinclude;
    public static volatile SingularAttribute<Fileformat, Short> compressedinzip;
    public static volatile SingularAttribute<Fileformat, Assettype> assettypeid;
    public static volatile SingularAttribute<Fileformat, Integer> previewwidth;
    public static volatile SingularAttribute<Fileformat, String> contenttype;
    public static volatile SingularAttribute<Fileformat, String> converterclass;
    public static volatile SingularAttribute<Fileformat, Short> canuploadthumbnail;
    public static volatile CollectionAttribute<Fileformat, Asset> assetCollection;
    public static volatile SingularAttribute<Fileformat, Integer> id;
    public static volatile SingularAttribute<Fileformat, String> fileextension;
    public static volatile SingularAttribute<Fileformat, Short> canvieworiginal;
    public static volatile SingularAttribute<Fileformat, Short> isconvertable;
    public static volatile SingularAttribute<Fileformat, String> description;
    public static volatile SingularAttribute<Fileformat, Short> isindexable;
    public static volatile SingularAttribute<Fileformat, String> name;
    public static volatile SingularAttribute<Fileformat, String> previewinclude;
    public static volatile SingularAttribute<Fileformat, String> thumbnailfilelocation;

}