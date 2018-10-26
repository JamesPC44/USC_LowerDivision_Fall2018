from sys import stdin

ID, PACKET, NUM_PACKETS, NUMBER_WORDS, DATA = range(5)

inputs = [line[:-1].split() for line in stdin]
inputs = [[int(i) for i in line[:4]] + [' '.join(line[4:])] for line in inputs]

ids_found = [False] * len(inputs)
awaiting_fragments = [None] * len(inputs)
finished_packets = []

for line in inputs:
    id = line[ID]
    if ids_found[id]:
        # silently drop packet
        continue
    if line[NUM_PACKETS] == 1:
        ids_found[id] = True
        finished_packets.append(line[DATA])
    else:
        if awaiting_fragments[id] is None:
            awaiting_fragments[id] = [None] * line[NUM_PACKETS]
        awaiting_fragments[id][line[PACKET]] = line[DATA]
        if all(awaiting_fragments[id]):
            ids_found[id] = True
            finished_packets.append(' '.join(awaiting_fragments[id]))

finished_packets.sort()
for packet in finished_packets:
    print(packet)
