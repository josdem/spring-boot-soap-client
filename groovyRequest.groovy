@Grab('com.github.groovy-wslite:groovy-wslite:1.1.3')

import wslite.soap.SOAPClient

File file = new File('request.xml')
assert file.exists()

String url = 'http://localhost:8080/ws'

def client = new SOAPClient(url)
def response = client.send(file.text)

print response.text
assert 200 == response.httpResponse.statusCode
