# -*- coding: utf-8 -*-

from UserInfo_pb2 import UserInfo
from google.protobuf import json_format
from google.protobuf import text_format

ui = UserInfo()

ui.userID = "2016211591"
ui.userName = "WeehaoTang"
ui.password = "2016211591"
ui.age = 21


print(ui.IsInitialized())  

print(ui.ListFields())  

ui_binary = ui.SerializeToString()  

with open("ui.binary.txt", "wb+") as f:  
    f.write(ui_binary)

another_ui = UserInfo()
another_ui.ParseFromString(ui_binary)
print(another_ui)


