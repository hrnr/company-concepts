#company-concepts
Extracts keywords describing company business with power of IBM Watson. Simple Java console application.

##tldr;
```
gradle run -Dexec.args="-c credentials.json input.json output.json"
```

##building

Project uses gradle for building.

```
gradle jar
```

##running

You need Watson Alchemy API key to run this program. When you register new Watson Alchemy service in bluemix you should get this JSON:

```
{
    "url": "https://gateway-a.watsonplatform.net/calls",
    "apikey": "<your actual api key>"
}
``` 

You must provide *path* to this credentials JSON with `-c` option.

###synopsis
```
usage: company_concepts [OPTIONS]... [INPUT FILE] [OUTPUT FILE]
 -c <credentials>   path to JSON file with API credentials for IBM Watson
                    AlchemyAPI.
```

###example
```
gradle run -Dexec.args="-c credentials.json input.json output.json"
```

###tests

Test are using JUnit and are integrated with gradle build. Tests require access to Watson, you need to provide path to credentials JSON via Java system property `watson.credentials`.

```
gradle test -Dwatson.credentials="credentials.json"
```

##example
input.json:
```
[
{
	"name": "Google",
	"url": "http://google.com"
},
{
	"name": "Oracle",
	"url": "https://www.oracle.com/"
},
{
	"name": "IBM",
	"url": "http://www.ibm.com/us-en/"
},
{
	"name": "Monsanto",
	"url": "http://www.monsanto.com/pages/default.aspx"
},
{
	"name": "Shell",
	"url": "http://www.shell.com/"
},
{
	"name": "Google",
	"url": "https://en.wikipedia.org/wiki/Google"
},
{
	"name": "Oracle",
	"url": "https://en.wikipedia.org/wiki/Oracle_Corporation"
},
{
	"name": "IBM",
	"url": "https://en.wikipedia.org/wiki/IBM"
},
{
	"name": "Monsanto",
	"url": "https://en.wikipedia.org/wiki/Monsanto"
},
{
	"name": "Shell",
	"url": "https://en.wikipedia.org/wiki/Royal_Dutch_Shell"
}
]
```

output.json:
```
[
  {
    "name": "Google",
    "url": "http://google.com",
    "keywords": [
      "World Wide Web",
      "Google services",
      "Web 2.0",
      "IPhone",
      "Advanced search Language",
      "Advertising Programs Business",
      "+Google About Google",
      "Search settings",
      "Account Options",
      "Web History",
      "Wallet",
      "Gmail",
      "Docs",
      "Translate",
      "Blogger",
      "Privacy",
      "Images",
      "Maps",
      "Play",
      "Drive"
    ]
  },
  {
    "name": "Oracle",
    "url": "https://www.oracle.com/",
    "keywords": [
      "Cloud computing",
      "Oracle Corporation",
      "Database management system",
      "Oracle RAC",
      "Everything as a service",
      "Mark Hurd",
      "Oracle Database",
      "oracle cloud",
      "Oracle Cloud Platform",
      "Oracle cloud services",
      "Oracle Cloud applications",
      "Oracle Marketing Cloud",
      "Oracle Commerce Cloud",
      "Oracle Database Appliance",
      "Oracle Accelerated Buying",
      "new cloud services",
      "management cloud services",
      "Oracle Database deployments",
      "affordable Oracle Database",
      "Oracle OpenWorld Latin"
    ]
  },
  {
    "name": "IBM",
    "url": "http://www.ibm.com/us-en/",
    "keywords": [
      "Social network service",
      "Google",
      "Internet",
      "Twitter",
      "Weather",
      "Construction",
      "Met Office",
      "The Blind",
      "Deploy high-performance cloud",
      "IBM data centers",
      "official IBM product",
      "cognitive era",
      "cognitive business",
      "Cognitive technology",
      "intern’s fascination",
      "unstructured data",
      "YouTube channel",
      "no-charge trials",
      "data scientists",
      "Apache Spark"
    ]
  },
  {
    "name": "Monsanto",
    "url": "http://www.monsanto.com/pages/default.aspx",
    "keywords": [
      "Food",
      "Conversation",
      "The Conversation",
      "We Are the World",
      "RR2 PRO™ soybeans",
      "INTACTA RR2 PRO™",
      "first‐ever insect-protected trait",
      "lepidopteran pests",
      "reliable control",
      "bigger discussion",
      "sustainable solutions",
      "meal",
      "accessibility",
      "conversation",
      "farmers",
      "importance",
      "researchers",
      "experts",
      "time",
      "range"
    ]
  },
  {
    "name": "Shell",
    "url": "http://www.shell.com/",
    "keywords": [
      "Sun",
      "Electricity",
      "Solar power",
      "Petroleum",
      "Hydropower",
      "Time",
      "Electrical generator",
      "World",
      "Shell Eco-marathon Europe",
      "Shell pilot plant",
      "Batak people",
      "Football legend",
      "Palawan island",
      "Future London",
      "waste mounts",
      "local project",
      "solar energy",
      "electric light",
      "petrol",
      "hydropower"
    ]
  },
  {
    "name": "Google",
    "url": "https://en.wikipedia.org/wiki/Google",
    "keywords": [
      "Google services",
      "Google search",
      "Android",
      "Web search engine",
      "Google Apps",
      "Picasa",
      "Sergey Brin",
      "google search",
      "Google search engine",
      "Google Fiber",
      "Google Analytics",
      "Numerous Google sites",
      "Google Drive",
      "Google Fiber broadband",
      "Google Earth",
      "Google Docs",
      "Google Photos",
      "Google Chrome",
      "Google Watch",
      "Google employees"
    ]
  },
  {
    "name": "Oracle",
    "url": "https://en.wikipedia.org/wiki/Oracle_Corporation",
    "keywords": [
      "Oracle Corporation",
      "Oracle Database",
      "Oracle software",
      "Oracle Fusion Middleware",
      "Database management system",
      "Larry Ellison",
      "Database",
      "Oracle Application Server",
      "Oracle vs Oracle",
      "oracle database",
      "oracle systems corporation",
      "Oracle E-Business Suite",
      "product Oracle Database",
      "Oracle Database version",
      "Oracle database programming",
      "Oracle Enterprise Manager",
      "Oracle Fusion",
      "Oracle Corporation products",
      "Oracle support web",
      "Oracle Retail Suite"
    ]
  },
  {
    "name": "IBM",
    "url": "https://en.wikipedia.org/wiki/IBM",
    "keywords": [
      "Thomas J. Watson",
      "Thomas J. Watson Research Center",
      "Personal computer",
      "Herman Hollerith",
      "IBM Personal Computer",
      "Computing Tabulating Recording Corporation",
      "Thomas Watson, Jr.",
      "company",
      "IBM employees",
      "New York",
      "IBM Research",
      "IBM World Trade",
      "IBM Micro Electronics",
      "IBM Global Technology",
      "IBM Linux Technology",
      "IBM Big Blue",
      "International Business Machines",
      "IBM Scientific Center",
      "IBM engineer George",
      "revolutionary IBM System/360"
    ]
  },
  {
    "name": "Monsanto",
    "url": "https://en.wikipedia.org/wiki/Monsanto",
    "keywords": [
      "Genetically modified food",
      "Genetically modified organism",
      "Bacillus thuringiensis",
      "Cotton",
      "Bovine somatotropin",
      "Roundup",
      "Genetic engineering",
      "Monsanto Company",
      "Edgar Monsanto Queeny",
      "Monsanto chemical plants",
      "Monsanto Choice Genetics",
      "son Edgar Monsanto",
      "current Monsanto Company",
      "pre-1997 Monsanto Company",
      "Monsanto subsidiary",
      "Monsanto scientists",
      "Monsanto Queeny safety",
      "separate Monsanto subsidiary",
      "Monsanto process",
      "Monsanto chemist John"
    ]
  },
  {
    "name": "Shell",
    "url": "https://en.wikipedia.org/wiki/Royal_Dutch_Shell",
    "keywords": [
      "Royal Dutch Shell",
      "Petroleum",
      "Natural gas",
      "Petroleum industry",
      "Oil well",
      "Shell Oil Company",
      "Netherlands",
      "Oil field",
      "dutch shell plc",
      "Dutch Shell Group",
      "Dutch Shell revenue",
      "Shell Petroleum Corporation",
      "Shell Chemicals",
      "sea shell",
      "UK-based Shell Transport",
      "Shell International B.V.",
      "Shell petrol stations",
      "Shell Mex House",
      "sea shell Pecten",
      "Dutch Shell fuel"
    ]
  }
]
```