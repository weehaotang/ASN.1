from pyasn1.codec.der.decoder import decode as der_decoder
from UserInfo import UserInfo
import asn1tools
import struct
# class DecodeAsn1:
#     if __name__ == "__main__":
#         # foo = asn1tools.compile_file('tests/files/foo.asn', 'uper')
#         # encoded = open('test_ui','rb').read()
#         # encoded = struct.unpack('s',encoded)
#         # print(encoded)
#         # print(foo.decode('Question', encoded))
text = file = open('test_ui', 'rb').read()
result = der_decoder(text, asn1Spec=UserInfo())
print(result[0].prettyPrint())
