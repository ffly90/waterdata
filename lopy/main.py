import pycom
from network import LoRa
import socket
import time
import ubinascii
import json
import utime
from onewire import DS18X20
from onewire import OneWire
from machine import UART
from machine import Pin

interval = 5000

uart2 = UART(2, baudrate=9600, bits=8, stop=1, pins=('P4','P3'))
data={}
def ph():
    uart2.readall()
    uart2.write('R\r')
    time.sleep(1)
    val=uart2.readline()
    data['pH']=str(val,"utf-8")
    data['pH'] = data['pH'].replace("\r", "")

def temp():
    temp_raw=temp_sens.read_temp_async()
    time.sleep(1)
    temp_sens.start_conversion()
    temp=temp_raw
    data['temp']=temp

def sendLora():
    pycom.rgbled(0x00A000)
    #s.setblocking(True)
    msg=json.dumps(data)
    print(msg)
    s.send(msg)

    # make the socket non-blocking
    # (because if there's no data received it will block forever...)
    #s.setblocking(False)
    pycom.rgbled(0x000000)


pycom.heartbeat(False)

# Initialise LoRa in LORAWAN mode.
# Please pick the region that matches where you are using the device:
# Asia = LoRa.AS923
# Australia = LoRa.AU915
# Europe = LoRa.EU868
# United States = LoRa.US915
pycom.rgbled(0xA00000)
lora = LoRa(mode=LoRa.LORAWAN, region=LoRa.EU868)
uart = UART(1, baudrate=9600, bits=8, pins=('P20','P21'),timeout_chars=50)
# create an OTAA authentication parameters
app_eui = ubinascii.unhexlify('70B3D57ED00114D6')
app_key = ubinascii.unhexlify('ED9425C459DD25020CA5A24AEE1539FC')
uart2.write('C,0\r')
uart2.readall()
uart2.write('*OK,0\r')
uart2.readall()

ow = OneWire(Pin('P12'))
temp_sens = DS18X20(ow)
temp_raw=temp_sens.read_temp_async()
time.sleep(1)
temp_sens.start_conversion()
# join a network using OTAA (Over the Air Activation)
lora.join(activation=LoRa.OTAA, auth=(app_eui, app_key), timeout=0)
print('try to join... (9600)')
pycom.rgbled(0x0000A0)
# wait until the module has joined the network
while not lora.has_joined():
    time.sleep(2.5)
    print('Not yet joined...')

# create a LoRa socket
s = socket.socket(socket.AF_LORA, socket.SOCK_RAW)
print("joined");
# set the LoRaWAN data rate
s.setsockopt(socket.SOL_LORA, socket.SO_DR, 5)
pycom.rgbled(0x000000)
last=utime.ticks_ms()
while True:
    sw = last + interval
    ph()
    temp()
    if utime.ticks_ms() > sw:
        sendLora()
        last=utime.ticks_ms()


#while True:
#    if uart.any() > 0:
        #print('Send UART')
        # make the socket blocking
        # (waits for the data to be sent and for the 2 receive windows to expire)
        #pycom.rgbled(0x00A000)
        #s.setblocking(True)

        # send some data
        #msg = uart.readline()
        #print(msg)
        #s.send(msg)

        # make the socket non-blocking
        # (because if there's no data received it will block forever...)
        #s.setblocking(False)
        #pycom.rgbled(0x000000)
