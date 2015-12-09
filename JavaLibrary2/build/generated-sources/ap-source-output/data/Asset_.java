package data;

import data.Asset;
import data.Assetbankuser;
import data.Assetentity;
import data.Assettype;
import data.CmCategory;
import data.Fileformat;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-09T21:50:36")
@StaticMetamodel(Asset.class)
public class Asset_ { 

    public static volatile SingularAttribute<Asset, String> uploadedthumbnailfile;
    public static volatile SingularAttribute<Asset, Fileformat> fileformatid;
    public static volatile SingularAttribute<Asset, Short> isbrandtemplate;
    public static volatile SingularAttribute<Asset, String> embeddedpreviewcliplocation;
    public static volatile SingularAttribute<Asset, Integer> numdownloads;
    public static volatile SingularAttribute<Asset, Short> canembedfile;
    public static volatile SingularAttribute<Asset, Short> issensitive;
    public static volatile SingularAttribute<Asset, Date> filecheckouttime;
    public static volatile SingularAttribute<Asset, Short> allowfeedback;
    public static volatile SingularAttribute<Asset, Assettype> assettypeid;
    public static volatile SingularAttribute<Asset, Date> expirydate;
    public static volatile SingularAttribute<Asset, Short> awaitingthumbnailregeneration;
    public static volatile SingularAttribute<Asset, Integer> agreementtypeid;
    public static volatile SingularAttribute<Asset, String> mediumfilelocation;
    public static volatile SingularAttribute<Asset, Integer> versionnumber;
    public static volatile SingularAttribute<Asset, Short> thumbnailgenerationfailed;
    public static volatile SingularAttribute<Asset, Short> advancedviewing;
    public static volatile SingularAttribute<Asset, Integer> id;
    public static volatile SingularAttribute<Asset, String> smallfilelocation;
    public static volatile SingularAttribute<Asset, String> author;
    public static volatile SingularAttribute<Asset, Assetbankuser> addedbyuserid;
    public static volatile SingularAttribute<Asset, Date> bulkuploadtimestamp;
    public static volatile SingularAttribute<Asset, String> originalfilename;
    public static volatile SingularAttribute<Asset, Date> lastdownloaded;
    public static volatile SingularAttribute<Asset, Asset> currentversionid;
    public static volatile SingularAttribute<Asset, BigInteger> filesizeinbytes;
    public static volatile SingularAttribute<Asset, Short> ispreviewrestricted;
    public static volatile SingularAttribute<Asset, Short> isnotduplicate;
    public static volatile SingularAttribute<Asset, Assetbankuser> submittedbyuserid;
    public static volatile SingularAttribute<Asset, Short> hasworkingfile;
    public static volatile SingularAttribute<Asset, String> importedassetid;
    public static volatile SingularAttribute<Asset, Date> datesubmitted;
    public static volatile CollectionAttribute<Asset, Asset> assetCollection2;
    public static volatile SingularAttribute<Asset, String> code;
    public static volatile CollectionAttribute<Asset, Asset> assetCollection1;
    public static volatile SingularAttribute<Asset, Date> datelastmodified;
    public static volatile CollectionAttribute<Asset, Asset> assetCollection;
    public static volatile SingularAttribute<Asset, Assetbankuser> lastmodifiedbyuserid;
    public static volatile SingularAttribute<Asset, String> filelocation;
    public static volatile SingularAttribute<Asset, Date> dateadded;
    public static volatile SingularAttribute<Asset, Integer> price;
    public static volatile CollectionAttribute<Asset, CmCategory> cmCategoryCollection;
    public static volatile SingularAttribute<Asset, Short> isunsubmitted;
    public static volatile SingularAttribute<Asset, Assetbankuser> filecheckedoutbyuserid;
    public static volatile SingularAttribute<Asset, Integer> numviews;
    public static volatile SingularAttribute<Asset, Assetentity> assetentityid;
    public static volatile SingularAttribute<Asset, String> originalfilelocation;
    public static volatile SingularAttribute<Asset, String> thumbnailfilelocation;
    public static volatile SingularAttribute<Asset, Date> datefirstapproved;

}