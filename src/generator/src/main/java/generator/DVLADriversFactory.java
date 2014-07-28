package generator;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;



/**
 * {
  "_id": "181741733",
  "currentDriverNumber": "BTAEP608175XH9FR",
  "driverNumberHistory": [
    {
      "id": "BTAEP608175XH9FR"
    }
  ],
  "licence": {
    "validFrom": ISODate("1988-10-04T00:00:00Z"),
    "validTo": ISODate("2035-08-16T00:00:00Z"),
    "directiveStatus": 1,
    "cardExpiryDate": ISODate("2035-08-16T00:00:00Z"),
    "regimeType": "",
    "currentIssueNum": "77",
    "entitlements": [
      {
        "code": "A",
        "provisional": true,
        "priorTo": false,
        "vocational": false
      },
      {
        "code": "B",
        "provisional": false,
        "priorTo": false,
        "vocational": false
      },
      {
        "code": "BE",
        "provisional": false,
        "priorTo": false,
        "vocational": false
      },
      {
        "code": "C1E",
        "provisional": false,
        "priorTo": false,
        "vocational": false
      },
      {
        "code": "D1E",
        "provisional": false,
        "priorTo": false,
        "restrictions": [
          {
            "code": "1"
          }
        ],
        "vocational": false
      },
      {
        "code": "F",
        "provisional": false,
        "priorTo": false,
        "vocational": false
      },
      {
        "code": "G",
        "provisional": true,
        "priorTo": false,
        "vocational": false
      },
      {
        "code": "H",
        "provisional": true,
        "priorTo": false,
        "vocational": false
      },
      {
        "code": "K",
        "provisional": false,
        "priorTo": false,
        "vocational": false
      },
      {
        "code": "L",
        "provisional": false,
        "priorTo": false,
        "vocational": false
      },
      {
        "code": "N",
        "provisional": false,
        "priorTo": false,
        "vocational": false
      },
      {
        "code": "P",
        "provisional": false,
        "priorTo": false,
        "vocational": false
      }
    ]
  },
  "status": {
    "code": "F"
  },
  "driverStatedFlags": {
    "duplicateOfLicence": false,
    "exchangeOfLicence": false,
    "higherFeePaid": false,
    "onYoungDriverScheme": false,
    "lifeFeePaid": true,
    "medicalInvestigationRequiredForLicenceIssue": false,
    "ordinaryMedicalInvestigationInProgress": false,
    "ordinaryMedicalDeclarationMade": false,
    "ordinaryMedicalPapersHeld": false,
    "photoInvitationSent": "N",
    "receivesMobilityAllowance": false,
    "restrictedAsSpecifiedinSecretaryofStateNotice": false,
    "sightCorrectionRequired": false,
    "vocationalMedicalPapersHeld": false,
    "vocationalMedicalInvestigationInProgress": false,
    "excessEndorsements": false
  },
  "firstProvisionalDate": ISODate("1983-04-01T00:00:00Z"),
  "HROType": "",
  "testPasses": [
    {
      "entitlementType": "B",
      "statusType": "ONLIC",
      "testPassDate": ISODate("1988-09-28T00:00:00Z"),
      "extended": false,
      "harmonised": true,
      "automatic": false,
      "lessThanEqual25kw": false
    }
  ],
  "nslInCorruptedRange": false,
  "licenceTokens": [
    {
      "cntptIssNumSuffix": "",
      "currentStatus": {
        "code": "0"
      },
      "issueNumber": "E1",
      "issuingAuthority": "DVLA",
      "languageType": "",
      "pprDocNum": "",
      "photoBarNum": "",
      "typeCode": "UKDL",
      "cancelled": false,
      "claimed": false,
      "cardNum": ""
    },
    {
      "cntptIssNumSuffix": "",
      "currentStatus": {
        "code": "2"
      },
      "dateOfIssue": ISODate("1988-10-04T00:00:00Z"),
      "issueNumber": "77",
      "issuingAuthority": "DVLA",
      "languageType": "B",
      "pprDocNum": "960151726315",
      "photoBarNum": "",
      "typeCode": "UKDL",
      "cancelled": false,
      "claimed": false,
      "cardNum": ""
    }
  ],
  "birthDetails": {
    "date": ISODate("1965-08-17T00:00:00Z"),
    "country": {
      "name": "NK",
      "code": "",
      "internalCode": ""
    }
  },
  "deathDetails": {
    "vlDeathDateCode": "A"
  },
  "address": {
    "insecure": false,
    "country": {
      "code": "GBR",
      "internalCode": "3"
    },
    "langCode": "EN",
    "pafKey": "",
    "orgName": "",
    "buildingNumber": "",
    "buildingName": "",
    "subBuildingName": "",
    "tfare": "",
    "dtfare": "",
    "dLocality": "",
    "ddLocality": "",
    "postTown": "",
    "postCode": "",
    "poBox": "",
    "type": "UN",
    "validFrom": ISODate("2013-01-04T00:00:00Z"),
    "vanityInfo": "",
    "uLine": [
      "3 GI TEST DATA DO NOT DELIVER",
      "",
      "",
      "",
      "PRESTATYN"
    ],
    "uPostCode": "LL198YF"
  },
  "name": {
    "title": "Mr",
    "givenName": [
      "XLBZW",
      "HZFW",
      ""
    ],
    "familyName": "BTAEPX",
    "isTitleAddress": false
  },
  "gender": 1,
  "adi": false,
  "military": false,
  "agyNotEmigCountry": "",
  "highRiskOffender": false,
  "organDonor": false,
  "nationality": {
    "code": ""
  },
  "perNotEmigCountry": "",
  "preferredLanguage": "B"
}
 * @author norberto
 *
 */
public class DVLADriversFactory implements DocumentFactory {

//    private SecureRandom random = new SecureRandom();
    private Random rand = new Random();
    private long beginTime = Timestamp.valueOf("1983-09-25 00:00:00").getTime();
    private long endTime = Timestamp.valueOf("2014-09-25 00:00:00").getTime();
    
    private String generateDriverNumber(){
        
        return UUID.randomUUID().toString();
    }
    
    
    private DBObject genDriverHistory(final String driverNumber){
        DBObject hst = new BasicDBObject();
        hst.put("id", driverNumber);
        return hst;
    }
    /**
     * "licence": {
    "validFrom": ISODate("1988-10-04T00:00:00Z"),
    "validTo": ISODate("2035-08-16T00:00:00Z"),
    "directiveStatus": 1,
    "cardExpiryDate": ISODate("2035-08-16T00:00:00Z"),
    "regimeType": "",
    "currentIssueNum": "77",
    "entitlements": [
      {
        "code": "A",
        "provisional": true,
        "priorTo": false,
        "vocational": false
      },
      {
        "code": "B",
        "provisional": false,
        "priorTo": false,
        "vocational": false
      },
      {
        "code": "BE",
        "provisional": false,
        "priorTo": false,
        "vocational": false
      },
      {
        "code": "C1E",
        "provisional": false,
        "priorTo": false,
        "vocational": false
      },
      {
        "code": "D1E",
        "provisional": false,
        "priorTo": false,
        "restrictions": [
          {
            "code": "1"
          }
        ],
        "vocational": false
      },
      {
        "code": "F",
        "provisional": false,
        "priorTo": false,
        "vocational": false
      },
      {
        "code": "G",
        "provisional": true,
        "priorTo": false,
        "vocational": false
      },
      {
        "code": "H",
        "provisional": true,
        "priorTo": false,
        "vocational": false
      },
      {
        "code": "K",
        "provisional": false,
        "priorTo": false,
        "vocational": false
      },
      {
        "code": "L",
        "provisional": false,
        "priorTo": false,
        "vocational": false
      },
      {
        "code": "N",
        "provisional": false,
        "priorTo": false,
        "vocational": false
      },
      {
        "code": "P",
        "provisional": false,
        "priorTo": false,
        "vocational": false
      }
    ]
  }
     * @return
     */
    private DBObject genLicence(){
        DBObject lic = new BasicDBObject();
        lic.put("validFrom", genDate());
        lic.put("validTo", genDate());
        lic.put("directiveStatus", 1);
        lic.put("cardExpiryDate", genDate());
        lic.put("regimeType", "");
        lic.put("currentIssueNum", rand.nextInt(100));
        
        return lic;
    }
    
    
    private DBObject buildEntitlement(String code){
        DBObject entl = new BasicDBObject();
        entl.put("code", code);
        entl.put("provisional", rand.nextBoolean());
        entl.put("priorTo", rand.nextBoolean());
        entl.put("vocational", rand.nextBoolean());
        return entl;
    }
    
    private BasicDBList genEntitlements(){
        String[] cs = {"A","B","BE","C1E","D1E","F","G","H","K","L","N","p",};
        BasicDBList list = new BasicDBList();
        for(String c : cs){
            list.add(buildEntitlement(c));
        }
            
        return list;
    }
    
    
    
    
    private Date genDate(){
        long diff = endTime - beginTime + 1;
        long d = beginTime + (long) (Math.random() * diff);
        Date randomDate = new Date(d);
        return randomDate;
    }
    
    
    private DBObject genStatus(){
        return new BasicDBObject( "code", String.valueOf( rand.nextInt(32)));
    }
    
    
    private DBObject genDriverFlags(){
        String [] tags = {"duplicateOfLicence", "exchangeOfLicence","higherFeePaid","onYoungDriverScheme",
                "lifeFeePaid","medicalInvestigationRequiredForLicenceIssue", "ordinaryMedicalInvestigationInProgress",
                "ordinaryMedicalDeclarationMade","ordinaryMedicalPapersHeld","photoInvitationSent",
                "receivesMobilityAllowance","restrictedAsSpecifiedinSecretaryofStateNotice","sightCorrectionRequired",
                "vocationalMedicalPapersHeld","vocationalMedicalInvestigationInProgress","excessEndorsements"};
        
        DBObject driverFlags = new BasicDBObject();
        
        for( String t : tags){
            driverFlags.put(t, rand.nextBoolean());
        }
        
        return driverFlags;
        
    }
    
    private String randHROType(){
        String[] hros = {  "","A","1","B","3","2"};
        int pos = rand.nextInt(hros.length);
        return hros[pos];
    }
    
    
    public DBObject produce() {
        
        DBObject document = new BasicDBObject();
        String driverNumber = generateDriverNumber();
        document.put("currentDriverNumber", driverNumber);
        document.put("driverNumberHistory", genDriverHistory(driverNumber));
        document.put("entitlements", genEntitlements());
        document.put("status", genStatus());
        document.put("driverStatedFlags", genDriverFlags());
        document.put("firstProvisionalDate", genDate());
        document.put("HROType", randHROType());
        /*
       
  
  
  "testPasses": [
    {
      "entitlementType": "B",
      "statusType": "ONLIC",
      "testPassDate": ISODate("1988-09-28T00:00:00Z"),
      "extended": false,
      "harmonised": true,
      "automatic": false,
      "lessThanEqual25kw": false
    }
  ],
  "nslInCorruptedRange": false,
  "licenceTokens": [
    {
      "cntptIssNumSuffix": "",
      "currentStatus": {
        "code": "0"
      },
      "issueNumber": "E1",
      "issuingAuthority": "DVLA",
      "languageType": "",
      "pprDocNum": "",
      "photoBarNum": "",
      "typeCode": "UKDL",
      "cancelled": false,
      "claimed": false,
      "cardNum": ""
    },
    {
      "cntptIssNumSuffix": "",
      "currentStatus": {
        "code": "2"
      },
      "dateOfIssue": ISODate("1988-10-04T00:00:00Z"),
      "issueNumber": "77",
      "issuingAuthority": "DVLA",
      "languageType": "B",
      "pprDocNum": "960151726315",
      "photoBarNum": "",
      "typeCode": "UKDL",
      "cancelled": false,
      "claimed": false,
      "cardNum": ""
    }
  ],
  "birthDetails": {
    "date": ISODate("1965-08-17T00:00:00Z"),
    "country": {
      "name": "NK",
      "code": "",
      "internalCode": ""
    }
  },
  "deathDetails": {
    "vlDeathDateCode": "A"
  },
  "address": {
    "insecure": false,
    "country": {
      "code": "GBR",
      "internalCode": "3"
    },
    "langCode": "EN",
    "pafKey": "",
    "orgName": "",
    "buildingNumber": "",
    "buildingName": "",
    "subBuildingName": "",
    "tfare": "",
    "dtfare": "",
    "dLocality": "",
    "ddLocality": "",
    "postTown": "",
    "postCode": "",
    "poBox": "",
    "type": "UN",
    "validFrom": ISODate("2013-01-04T00:00:00Z"),
    "vanityInfo": "",
    "uLine": [
      "3 GI TEST DATA DO NOT DELIVER",
      "",
      "",
      "",
      "PRESTATYN"
    ],
    "uPostCode": "LL198YF"
  },
  "name": {
    "title": "Mr",
    "givenName": [
      "XLBZW",
      "HZFW",
      ""
    ],
    "familyName": "BTAEPX",
    "isTitleAddress": false
  },
  "gender": 1,
  "adi": false,
  "military": false,
  "agyNotEmigCountry": "",
  "highRiskOffender": false,
  "organDonor": false,
  "nationality": {
    "code": ""
  },
  "perNotEmigCountry": "",
  "preferredLanguage": "B"
}
         */
        
        return document;
    }

}
