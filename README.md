# CaseManagement

![image](https://user-images.githubusercontent.com/75727533/143845624-7a17acf6-81c1-4e38-a477-8315306c2daf.png)

## Leverantör

Sundsvalls kommun

## Config

### Production-config

- **API Gateway:**                  api-i.sundsvall.se
    - **Endpoint:**                 Production
- **Server:**                       microservices.sundsvall.se
- **DB:**                           Maria DB
- **Version av integrationer:**     Produktion

### Test-config

- **API Gateway:**                  api-i-test.sundsvall.se
    - **Endpoint:**                 Production
- **Server:**                       microservices-test.sundsvall.se
- **DB:**                           Maria DB
- **Version av integrationer:**     Test

### Sandbox-config

- **API Gateway:**                  api-i-test.sundsvall.se
    - **Endpoint:**                 Sandbox
- **Server:**                       microservices-test.sundsvall.se
- **DB:**                           H2 (in-memory)
- **Version av integrationer:**     Mockade (Wiremock)

## Integrationer
Denna applikation har integrationer mot:
* Lantmäteriet
* Sokigo FB
* CitizenMapping (Sundsvalls kommun)
* ByggR
* Ecos2

## Miljövariabler
Dessa miljövariabler måste sättas för att det ska gå att köra applikationen.

FBWEBB_ORIGIN<br/>
FB_USER<br/>
FB_PASSWORD<br/>
LANTMATERIET_ORIGIN<br/>
LANTMATERIET_CONSUMER_KEY<br/>
LANTMATERIET_CONSUMER_SECRET<br/>
SUNDSVALLS_KOMMUN_INTERNAL_ORIGIN<br/>
SUNDSVALLS_KOMMUN_EXTERNAL_ORIGIN<br/>
SUNDSVALLS_KOMMUN_CONSUMER_KEY<br/>
SUNDSVALLS_KOMMUN_CONSUMER_SECRET<br/>
ARENDEEXPORT_SOAP_ORIGIN<br/>
MINUTMILJO_SOAP_ORIGIN<br/>
MINUTMILJO_USER<br/>
MINUTMILJO_PWD<br/>
DB_USERNAME<br/>
DB_PWD<br/>
DB_URL<br/>
DB_HIBERNATE_GENERATION<br/>

## Kör applikationen lokalt

För att köra applikationen lokalt måste du ha Docker installerat på din dator.

Använd detta kommando för att bygga och starta applikationen med sandbox-config: <br/>
`docker-compose -f src/main/docker/docker-compose_sandbox.yml build && docker-compose -f src/main/docker/docker-compose_sandbox.yml up`


