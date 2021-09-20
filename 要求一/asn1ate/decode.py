#coding=utf-8
from pyasn1.codec.der.decoder import decode as der_decoder 
from UserInfo import UserInfo

if __name__ == "__main__":
    text = file = open('test_ui', 'rb').read() 
    result = der_decoder(text, asn1Spec=UserInfo())
    print(result[0].prettyPrint())
