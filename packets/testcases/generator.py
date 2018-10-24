#!/usr/bin/env python3

import sys
import random

input_file = sys.argv[2]
output_file = sys.argv[3]


words = []
with open(sys.argv[1], "r") as f:
    for line in f:
        words.append(line.strip())

print("loaded {} words".format(len(words)))

messages = []
complete_messages = []

num_messages = random.randint(1,2**8)
#  num_messages = random.randint(3,)

print("going to generate {} messages".format(num_messages))

for i in range(num_messages):
    message_length = random.randint(1, 200)
    message = []
    packet = ""
    for j in range(message_length):
        packet += " " + random.choice(words)
        if (random.randint(1, 5) == 3):
                message.append(packet.strip())
                packet = ""
    messages.append(message)
    complete_messages.append(' '.join(message))

packets = []
for msgID in range(num_messages):
    numPackets = len(messages[msgID])
    for packetNum in range(numPackets):
        numWords = len(messages[msgID][packetNum].split(" "))
        packets.append([msgID, packetNum, numPackets, numWords, messages[msgID][packetNum]])

print("generated {} packets".format(len(packets)))

output_lines = []
dropped = 0

for packet in packets:
    msgID = packet[0]
    if (random.randint(1, 5) == 3):
        for i in range(random.randint(1, 20)):
            output_lines.append(' '.join([str(x) for x in packet]))
    elif (random.randint(1, 20) == 3):
        # invalidate message with dropped packet
        complete_messages[msgID] = ""
        dropped += 1
    else:
        output_lines.append(' '.join([str(x) for x in packet]))

print("dropped {} packets".format(dropped))

random.shuffle(output_lines)
with open(input_file, 'w') as f:
    for line in output_lines:
        f.write(line.strip())
        f.write("\n")

with open(output_file, 'w') as f:
    for message in sorted([x for x in complete_messages if x != '']):
        f.write(message)
        f.write('\n')

