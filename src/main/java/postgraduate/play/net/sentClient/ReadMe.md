一.需求
需求如题. 当多个客户端连接服务器时,服务器如何给指定的客户端发送消息.

二.解决方案
核心思想: 在服务器端,需保存不同客户端的socket列表及客户端相关信息.
socket含有发送方和接收方的ip和端口号,所以通过socket就能向指定的客户端发送消息.
经查阅资料,得到如下解决方案:
    用户连接时,立即向服务器发送自己的唯一ID（例如：I am 111或者I am 000）,服务器端将ID和对应的socket用map存储.
    向客户端发送消息时,就可以通过ID,找到对应的socket,然后向其发送消息.
    如果客户端ip固定,服务器每收到一个Socket都用Map

三.实践
说明:采用第一种解决方案,模拟服务器向指定的客户端发送消息.
服务端循环监听,第一个服务器进来,向其发送其自身序号,第二个进来,遍历socke列表,
向列表中的每一个客户端发送其对应的序号,从而达到服务器向指定客户端发送消息的功能.
每有一个新的客户端进入就会遍历客户端列表，并向每一个客户端发送他们的ID.

服务器端
ServerWatch.java和ServerThread.java

客户端：
Python实现：
程序一：
`#coding = utf-8
import socket
import threading

HOST = "localhost"
PORT = 30000

sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
sock.connect((HOST, PORT))

def test():
socketID = 'I am 111'
sock.sendall((socketID+'\r').encode())
while True:
data = sock.recv(1024).decode()
print('from Server: '+data)
sock.close()

if __name__ == '__main__':
test()`


程序二：
`#coding = utf-8
import socket
import threading

HOST = "localhost"
PORT = 30000

sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
sock.connect((HOST, PORT))
def test():
socketID = 'I am 000'
sock.sendall((socketID+'\r').encode())
while True:
data = sock.recv(1024).decode()
print('from Server: '+data)
sock.close()

if __name__ == '__main__':
test()`
