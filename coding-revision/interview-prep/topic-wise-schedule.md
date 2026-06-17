# Topic-Wise Schedule — Complete one topic fully (E → M → H), then next

> Pick one topic. Finish ALL Easy → ALL Medium → ALL Hard. Then move to the next topic. This builds deep expertise per topic before context-switching.

---

## Overview

- **24 topics, ~2 weeks each** (some 1.5 weeks, DP gets 3 weeks)
- **Total: ~11 months** at 2 hrs/day, 6 days/week
- **Per topic:** ~14 days = concepts (1d) + Easy (3d × 5 problems) + Medium (5d × 3) + Hard (5d × 3) + review (1d) = 45 problems

### Time per problem (with timer)
| Difficulty | Timer | If stuck past 2× timer |
|---|---|---|
| Easy | 20 min | hint → editorial → mark `[~]` partial → re-do in 48 hrs |
| Medium | 30 min | same |
| Hard | 45 min | OK to study editorial fully — write back your own solution next day |

### Topic order (easiest foundation → advanced)

| Tier | Weeks | Topics |
|---|---|---|
| 1. Foundations | 1–12 | arrays-and-strings, hashing, two-pointers, sliding-window, prefix-sum, sorting |
| 2. Core structures | 13–24 | binary-search, linked-list, stacks-and-queues, monotonic-stack, recursion-and-backtracking, trees-binary-tree |
| 3. Tree / advanced structures | 25–32 | binary-search-tree, tries, heaps-priority-queue, matrix-2d-grid |
| 4. Graphs | 33–36 | graphs-bfs-dfs, graphs-advanced |
| 5. Algorithm techniques | 37–44 | greedy, intervals, bit-manipulation, math-and-number-theory |
| 6. Hardest last | 45–48 | dynamic-programming (3 weeks), design-and-system-data-structures |

---

## Beginner ground rules (READ ONCE BEFORE STARTING)

1. **Brute force first.** Write the O(n²) solution before optimizing.
2. **Hand-trace** one tiny example (3 elements) BEFORE coding.
3. **Mark every row** in the topic file: `[x]` done, `[~]` partial, `[ ]` not yet.
4. **Re-do failures after 48 hours** until you solve them cold.
5. **Sunday = review day** every week. No new problems.
6. **Saturday = MOCK INTERVIEW day** — see the Mock Interview Protocol below.

---

## 🎤 Mock Interview Protocol — How Saturdays Work

Every Saturday is a **mock interview** simulated with this AI agent acting as your interviewer.

👉 **Full protocol + the copy-paste prompt** lives in **[`mock-interview.md`](mock-interview.md)**. Open it every Saturday morning, copy the prompt, fill in your topic, paste it into a fresh chat with me. I'll run the interview and write a post-mortem.

### Cadence summary

| Topic length | Saturdays in topic | Mock count |
|---|---|---|
| 14-day topic (most) | Day 6, Day 13 | 2 mocks |
| 10-day topic (Tries, Intervals, Bit) | Day 6 | 1 mock |
| 21-day DP | Day 6, Day 13, Day 20 | 3 mocks |

By end of program: **~46 mock interviews** across all topics.

### Format summary

| Mock # | Format | Time |
|---|---|---|
| #1 (mid-topic) | 1 Easy or Medium from this topic | 30 min |
| #2 (end of topic) | 1 Medium + 1 Hard from this topic | 75 min |
| #3 (DP only) | 2 Hards back-to-back | 90 min |

The AI will:
- Pick problem(s) randomly from the topic file (won't reveal the LC #/title)
- Drop **indirect hints only** — never name the pattern or data structure
- Run a 9-section post-mortem with hire signal + top 3 improvements + 3 drill problems

---

## Per-topic structure (with Saturday Mocks baked in)

Every 14-day topic now follows this rhythm:

| Day | Slot | What |
|---|---|---|
| 1 (Mon) | Concepts + 4 Easy | Read topic file's concepts |
| 2 (Tue) | 5 Easy | |
| 3 (Wed) | 6 Easy | ✓ all 15 Easy done |
| 4 (Thu) | 3 Medium | |
| 5 (Fri) | 3 Medium | |
| **6 (Sat)** | **🎤 MOCK #1** | 30 min: 1 Easy or 1 Medium from this topic |
| 7 (Sun) | Review | redo any `[~]`, no new problems |
| 8 (Mon) | 3 Medium | |
| 9 (Tue) | 3 Medium | |
| 10 (Wed) | 3 Medium | ✓ all 15 Medium done |
| 11 (Thu) | 3 Hard | |
| 12 (Fri) | 3 Hard | |
| **13 (Sat)** | **🎤 MOCK #2** | 75 min: 1 Medium + 1 Hard |
| 14 (Sun) | Hard finish + review | last batch of Hard + topic retrospective |

For **10-day topics** (Tries, Intervals, Bit Manipulation): only Day 6 has a mock, Days 7–10 cover the remaining content.

For **21-day DP**: mocks on Days 6, 13, and 20.

---

# 📘 Tier 1 — Foundations

---

## Topic 1: Arrays & Strings (Weeks 1–2) — file: `topics/arrays-and-strings.md`

| Day | Phase | Tasks |
|---|---|---|
| 1 | Read | Read concepts + Kadane & Dutch flag templates. Solve 4 Easy: **#1, 26, 27, 53** |
| 2 | Easy | 5 Easy: **#88, 121, 125, 136, 169** |
| 3 | Easy | 6 Easy: **#217, 242, 268, 283, 344, 387** ✓ all 15 Easy done |
| 4 | Medium | 3 Medium: **#3, 11, 15** |
| 5 | Medium | 3 Medium: **#31, 33, 36** |
| **6** | **🎤 Sat — Mock #1** | **30-min mock interview** — see [`mock-interview.md`](mock-interview.md) for the prompt. 1 Easy or Medium from this topic. |
| 7 | Sunday | **Review** — redo any partial |
| 8 | Medium | 3 Medium: **#128, 152, 189** |
| 9 | Medium | 3 Medium: **#238, 271, 347** ✓ all 15 Medium done |
| 10 | Hard | 2 Hard: **#4, 23** |
| 11 | Hard | 3 Hard: **#32, 41, 42** |
| 12 | Hard | 3 Hard: **#76, 84, 85** |
| **13** | **🎤 Sat — Mock #2** | **75-min mock interview** — see [`mock-interview.md`](mock-interview.md). 1 Medium (30 min) + 1 Hard (45 min) from this topic. |
| 14 | Hard + review | 3 Hard: **#354, 363, 480** ✓ all 15 Hard done. Update progress. |


**🔁 Stretch problems** — original problems displaced by mock days. Solve on Sunday review or fit in throughout the topic:

- *Day 6 (Mock #1) — original Medium*: #49, #56, #75
- *Day 13 (Mock #2) — original Hard*: #124, #128, #239, #295

---

## Topic 2: Hashing (Weeks 3–4) — file: `topics/hashing.md`

| Day | Phase | Tasks |
|---|---|---|
| 1 | Read + Easy | Read concepts. 4 Easy: **#1, 13, 136, 169** |
| 2 | Easy | 5 Easy: **#202, 205, 217, 219, 242** |
| 3 | Easy | 6 Easy: **#268, 290, 349, 350, 383, 387** ✓ Easy done |
| 4 | Medium | 3 Medium: **#3, 49, 128** |
| 5 | Medium | 3 Medium: **#138, 146, 187** |
| **6** | **🎤 Sat — Mock #1** | **30-min mock interview** — see [`mock-interview.md`](mock-interview.md) for the prompt. 1 Easy or Medium from this topic. |
| 7 | Sunday | **Review** |
| 8 | Medium | 3 Medium: **#438, 525, 560** |
| 9 | Medium | 3 Medium: **#567, 692, 994** ✓ Medium done |
| 10 | Hard | 3 Hard: **#30, 37, 76** |
| 11 | Hard | 3 Hard: **#126, 149, 159** |
| 12 | Hard | 3 Hard: **#218, 269, 295** |
| **13** | **🎤 Sat — Mock #2** | **75-min mock interview** — see [`mock-interview.md`](mock-interview.md). 1 Medium (30 min) + 1 Hard (45 min) from this topic. |
| 14 | Hard + review | 3 Hard: **#642, 711, 939** ✓ |


**🔁 Stretch problems** — original problems displaced by mock days. Solve on Sunday review or fit in throughout the topic:

- *Day 6 (Mock #1) — original Medium*: #271, #347, #380
- *Day 13 (Mock #2) — original Hard*: #336, #432, #460

---

## Topic 3: Two Pointers (Weeks 5–6) — file: `topics/two-pointers.md`

| Day | Phase | Tasks |
|---|---|---|
| 1 | Read + Easy | Read concepts + templates. 4 Easy: **#26, 27, 28, 88** |
| 2 | Easy | 5 Easy: **#125, 167, 234, 283, 344** |
| 3 | Easy | 6 Easy: **#345, 392, 455, 541, 925, 977** ✓ |
| 4 | Medium | 3 Medium: **#11, 15, 16** |
| 5 | Medium | 3 Medium: **#18, 19, 75** |
| **6** | **🎤 Sat — Mock #1** | **30-min mock interview** — see [`mock-interview.md`](mock-interview.md) for the prompt. 1 Easy or Medium from this topic. |
| 7 | Sunday | **Review** |
| 8 | Medium | 3 Medium: **#209, 287, 443** |
| 9 | Medium | 3 Medium: **#524, 845, 1004** ✓ |
| 10 | Hard | 3 Hard: **#4, 42, 76** |
| 11 | Hard | 3 Hard: **#159, 239, 259** |
| 12 | Hard | 3 Hard: **#295, 340, 363** |
| **13** | **🎤 Sat — Mock #2** | **75-min mock interview** — see [`mock-interview.md`](mock-interview.md). 1 Medium (30 min) + 1 Hard (45 min) from this topic. |
| 14 | Hard + review | 3 Hard: **#992, 1438, 1499** ✓ |


**🔁 Stretch problems** — original problems displaced by mock days. Solve on Sunday review or fit in throughout the topic:

- *Day 6 (Mock #1) — original Medium*: #80, #142, #151
- *Day 13 (Mock #2) — original Hard*: #632, #719, #826

---

## Topic 4: Sliding Window (Weeks 7–8) — file: `topics/sliding-window.md`

| Day | Phase | Tasks |
|---|---|---|
| 1 | Read + Easy | Concepts + fixed vs variable window. 4 Easy: **#121, 219, 643, 1456** |
| 2 | Easy | 5 Easy: **#1652, 1763, 2090, 2379, 2540** |
| 3 | Easy | 6 Easy: **#187, 1984, 2461, 1100, 1876, 2269** ✓ |
| 4 | Medium | 3 Medium: **#3, 209, 424** |
| 5 | Medium | 3 Medium: **#438, 487, 567** |
| **6** | **🎤 Sat — Mock #1** | **30-min mock interview** — see [`mock-interview.md`](mock-interview.md) for the prompt. 1 Easy or Medium from this topic. |
| 7 | Sunday | **Review** |
| 8 | Medium | 3 Medium: **#1052, 1248, 1493** |
| 9 | Medium | 3 Medium: **#1695, 1838, 2090** ✓ |
| 10 | Hard | 3 Hard: **#30, 76, 159** |
| 11 | Hard | 3 Hard: **#239, 340, 480** |
| 12 | Hard | 3 Hard: **#632, 727, 862** |
| **13** | **🎤 Sat — Mock #2** | **75-min mock interview** — see [`mock-interview.md`](mock-interview.md). 1 Medium (30 min) + 1 Hard (45 min) from this topic. |
| 14 | Hard + review | 3 Hard: **#1425, 1438, 1696** ✓ |


**🔁 Stretch problems** — original problems displaced by mock days. Solve on Sunday review or fit in throughout the topic:

- *Day 6 (Mock #1) — original Medium*: #904, #930, #1004
- *Day 13 (Mock #2) — original Hard*: #992, #995, #1234

---

## Topic 5: Prefix Sum (Weeks 9–10) — file: `topics/prefix-sum.md`

| Day | Phase | Tasks |
|---|---|---|
| 1 | Read + Easy | Concepts + 1D / 2D / hashmap variants. 4 Easy: **#303, 724, 1480, 1413** |
| 2 | Easy | 5 Easy: **#2270, 2389, 1893, 1854, 1991** |
| 3 | Easy | 6 Easy: **#1732, 1588, 1295, 1431, 1450, 1854** ✓ |
| 4 | Medium | 3 Medium: **#238, 304, 325** |
| 5 | Medium | 3 Medium: **#437, 523, 525** |
| **6** | **🎤 Sat — Mock #1** | **30-min mock interview** — see [`mock-interview.md`](mock-interview.md) for the prompt. 1 Easy or Medium from this topic. |
| 7 | Sunday | **Review** |
| 8 | Medium | 3 Medium: **#1109, 1314, 1352** |
| 9 | Medium | 3 Medium: **#1685, 1862, 1894** ✓ |
| 10 | Hard | 3 Hard: **#84, 363, 410** |
| 11 | Hard | 3 Hard: **#689, 862, 1074** |
| 12 | Hard | 3 Hard: **#1191, 1234, 1546** |
| **13** | **🎤 Sat — Mock #2** | **75-min mock interview** — see [`mock-interview.md`](mock-interview.md). 1 Medium (30 min) + 1 Hard (45 min) from this topic. |
| 14 | Hard + review | 3 Hard: **#2104, 2245, 2536** ✓ |


**🔁 Stretch problems** — original problems displaced by mock days. Solve on Sunday review or fit in throughout the topic:

- *Day 6 (Mock #1) — original Medium*: #528, #560, #974
- *Day 13 (Mock #2) — original Hard*: #1738, #1825, #1905

---

## Topic 6: Sorting (Weeks 11–12) — file: `topics/sorting.md`

| Day | Phase | Tasks |
|---|---|---|
| 1 | Read + Easy | Built-ins + custom comparators + quickselect. 4 Easy: **#88, 169, 242, 252** |
| 2 | Easy | 5 Easy: **#268, 350, 414, 561, 905** |
| 3 | Easy | 6 Easy: **#922, 944, 1051, 1122, 1356, 1859** ✓ |
| 4 | Medium | 3 Medium: **#56, 57, 75** |
| 5 | Medium | 3 Medium: **#148, 179, 215** |
| **6** | **🎤 Sat — Mock #1** | **30-min mock interview** — see [`mock-interview.md`](mock-interview.md) for the prompt. 1 Easy or Medium from this topic. |
| 7 | Sunday | **Review** |
| 8 | Medium | 3 Medium: **#451, 539, 692** |
| 9 | Medium | 3 Medium: **#853, 973, 1305** ✓ |
| 10 | Hard | 3 Hard: **#4, 23, 41** |
| 11 | Hard | 3 Hard: **#164, 218, 220** |
| 12 | Hard | 3 Hard: **#269, 315, 327** |
| **13** | **🎤 Sat — Mock #2** | **75-min mock interview** — see [`mock-interview.md`](mock-interview.md). 1 Medium (30 min) + 1 Hard (45 min) from this topic. |
| 14 | Hard + review | 3 Hard: **#632, 891, 1383** ✓ |


**🔁 Stretch problems** — original problems displaced by mock days. Solve on Sunday review or fit in throughout the topic:

- *Day 6 (Mock #1) — original Medium*: #274, #324, #347
- *Day 13 (Mock #2) — original Hard*: #354, #493, #502

---

# 📗 Tier 2 — Core Structures

---

## Topic 7: Binary Search (Weeks 13–14) — file: `topics/binary-search.md`

| Day | Phase | Tasks |
|---|---|---|
| 1 | Read + Easy | Classic + lower-bound + BS-on-answer. 4 Easy: **#35, 69, 70, 268** |
| 2 | Easy | 5 Easy: **#278, 367, 374, 392, 441** |
| 3 | Easy | 6 Easy: **#704, 744, 852, 1539, 1608, 2089** ✓ |
| 4 | Medium | 3 Medium: **#33, 34, 74** |
| 5 | Medium | 3 Medium: **#81, 153, 162** |
| **6** | **🎤 Sat — Mock #1** | **30-min mock interview** — see [`mock-interview.md`](mock-interview.md) for the prompt. 1 Easy or Medium from this topic. |
| 7 | Sunday | **Review** |
| 8 | Medium | 3 Medium: **#540, 658, 875** |
| 9 | Medium | 3 Medium: **#1011, 1283, 1482** ✓ |
| 10 | Hard | 3 Hard: **#4, 154, 174** |
| 11 | Hard | 3 Hard: **#295, 302, 354** |
| 12 | Hard | 3 Hard: **#410, 644, 668** |
| **13** | **🎤 Sat — Mock #2** | **75-min mock interview** — see [`mock-interview.md`](mock-interview.md). 1 Medium (30 min) + 1 Hard (45 min) from this topic. |
| 14 | Hard + review | 3 Hard: **#878, 1095, 1923** ✓ |


**🔁 Stretch problems** — original problems displaced by mock days. Solve on Sunday review or fit in throughout the topic:

- *Day 6 (Mock #1) — original Medium*: #240, #275, #287
- *Day 13 (Mock #2) — original Hard*: #719, #778, #786

---

## Topic 8: Linked List (Weeks 15–16) — file: `topics/linked-list.md`

| Day | Phase | Tasks |
|---|---|---|
| 1 | Read + Easy | Dummy nodes + fast/slow + in-place reversal. 4 Easy: **#21, 83, 141, 160** |
| 2 | Easy | 5 Easy: **#203, 206, 234, 237, 876** |
| 3 | Easy | 6 Easy: **#1290, 1474, 1721, 1836, 2058, 2181** ✓ |
| 4 | Medium | 3 Medium: **#2, 19, 24** |
| 5 | Medium | 3 Medium: **#61, 82, 86** |
| **6** | **🎤 Sat — Mock #1** | **30-min mock interview** — see [`mock-interview.md`](mock-interview.md) for the prompt. 1 Easy or Medium from this topic. |
| 7 | Sunday | **Review** |
| 8 | Medium | 3 Medium: **#142, 143, 146** |
| 9 | Medium | 3 Medium: **#147, 148, 328** ✓ |
| 10 | Hard | 3 Hard: **#23, 25, 117** |
| 11 | Hard | 3 Hard: **#432, 460, 622** |
| 12 | Hard | 3 Hard: **#707, 1206, 1670** |
| **13** | **🎤 Sat — Mock #2** | **75-min mock interview** — see [`mock-interview.md`](mock-interview.md). 1 Medium (30 min) + 1 Hard (45 min) from this topic. |
| 14 | Hard + review | 3 Hard: **#725, 369, 138** ✓ |


**🔁 Stretch problems** — original problems displaced by mock days. Solve on Sunday review or fit in throughout the topic:

- *Day 6 (Mock #1) — original Medium*: #92, #109, #138
- *Day 13 (Mock #2) — original Hard*: #379, #1171, #1019

---

## Topic 9: Stacks & Queues (Weeks 17–18) — file: `topics/stacks-and-queues.md`

| Day | Phase | Tasks |
|---|---|---|
| 1 | Read + Easy | ArrayDeque APIs. 4 Easy: **#20, 155, 225, 232** |
| 2 | Easy | 5 Easy: **#234, 496, 682, 844, 933** |
| 3 | Easy | 6 Easy: **#1021, 1047, 1614, 2073, 2696, 3174** ✓ |
| 4 | Medium | 3 Medium: **#71, 150, 173** |
| 5 | Medium | 3 Medium: **#227, 341, 394** |
| **6** | **🎤 Sat — Mock #1** | **30-min mock interview** — see [`mock-interview.md`](mock-interview.md) for the prompt. 1 Easy or Medium from this topic. |
| 7 | Sunday | **Review** |
| 8 | Medium | 3 Medium: **#622, 641, 739** |
| 9 | Medium | 3 Medium: **#921, 946, 1249** ✓ |
| 10 | Hard | 3 Hard: **#32, 42, 84** |
| 11 | Hard | 3 Hard: **#85, 224, 239** |
| 12 | Hard | 3 Hard: **#295, 316, 321** |
| **13** | **🎤 Sat — Mock #2** | **75-min mock interview** — see [`mock-interview.md`](mock-interview.md). 1 Medium (30 min) + 1 Hard (45 min) from this topic. |
| 14 | Hard + review | 3 Hard: **#772, 895, 1944** ✓ |


**🔁 Stretch problems** — original problems displaced by mock days. Solve on Sunday review or fit in throughout the topic:

- *Day 6 (Mock #1) — original Medium*: #402, #456, #503
- *Day 13 (Mock #2) — original Hard*: #591, #726, #770

---

## Topic 10: Monotonic Stack (Weeks 19–20) — file: `topics/monotonic-stack.md`

| Day | Phase | Tasks |
|---|---|---|
| 1 | Read + Easy | Next greater / smaller template. 4 Easy: **#496, 1019, 682, 844** |
| 2 | Easy | 5 Easy: **#1047, 155, 232, 225, 1700** |
| 3 | Easy | 6 Easy: **#933, 1021, 1614, 2696, 1475, 3174** ✓ |
| 4 | Medium | 3 Medium: **#402, 456, 503** |
| 5 | Medium | 3 Medium: **#739, 853, 901** |
| **6** | **🎤 Sat — Mock #1** | **30-min mock interview** — see [`mock-interview.md`](mock-interview.md) for the prompt. 1 Easy or Medium from this topic. |
| 7 | Sunday | **Review** |
| 8 | Medium | 3 Medium: **#1762, 1944, 2104** |
| 9 | Medium | 3 Medium: **#2487, 1003, 71** ✓ |
| 10 | Hard | 3 Hard: **#42, 84, 85** |
| 11 | Hard | 3 Hard: **#316, 321, 768** |
| 12 | Hard | 3 Hard: **#895, 975, 1130** |
| **13** | **🎤 Sat — Mock #2** | **75-min mock interview** — see [`mock-interview.md`](mock-interview.md). 1 Medium (30 min) + 1 Hard (45 min) from this topic. |
| 14 | Hard + review | 3 Hard: **#1793, 962, 2334** ✓ |


**🔁 Stretch problems** — original problems displaced by mock days. Solve on Sunday review or fit in throughout the topic:

- *Day 6 (Mock #1) — original Medium*: #907, #946, #1249
- *Day 13 (Mock #2) — original Hard*: #1063, #1856, #2030

---

## Topic 11: Recursion & Backtracking (Weeks 21–22) — file: `topics/recursion-and-backtracking.md`

| Day | Phase | Tasks |
|---|---|---|
| 1 | Read + Easy | Backtrack template + undo state. 4 Easy: **#21, 70, 104, 226** |
| 2 | Easy | 5 Easy: **#231, 257, 344, 401, 509** |
| 3 | Easy | 6 Easy: **#543, 559, 589, 617, 700, 938** ✓ |
| 4 | Medium | 3 Medium: **#17, 22, 39** |
| 5 | Medium | 3 Medium: **#40, 46, 47** |
| **6** | **🎤 Sat — Mock #1** | **30-min mock interview** — see [`mock-interview.md`](mock-interview.md) for the prompt. 1 Easy or Medium from this topic. |
| 7 | Sunday | **Review** |
| 8 | Medium | 3 Medium: **#90, 93, 131** |
| 9 | Medium | 3 Medium: **#216, 491, 698** ✓ |
| 10 | Hard | 3 Hard: **#10, 37, 44** |
| 11 | Hard | 3 Hard: **#51, 52, 60** |
| 12 | Hard | 3 Hard: **#87, 126, 140** |
| **13** | **🎤 Sat — Mock #2** | **75-min mock interview** — see [`mock-interview.md`](mock-interview.md). 1 Medium (30 min) + 1 Hard (45 min) from this topic. |
| 14 | Hard + review | 3 Hard: **#425, 489, 980** ✓ |


**🔁 Stretch problems** — original problems displaced by mock days. Solve on Sunday review or fit in throughout the topic:

- *Day 6 (Mock #1) — original Medium*: #77, #78, #79
- *Day 13 (Mock #2) — original Hard*: #212, #282, #301

---

## Topic 12: Trees — Binary Tree (Weeks 23–24) — file: `topics/trees-binary-tree.md`

| Day | Phase | Tasks |
|---|---|---|
| 1 | Read + Easy | All 3 traversals + BFS. 4 Easy: **#94, 100, 101, 104** |
| 2 | Easy | 5 Easy: **#108, 110, 111, 112, 144** |
| 3 | Easy | 6 Easy: **#145, 226, 257, 404, 543, 617** ✓ |
| 4 | Medium | 3 Medium: **#102, 103, 105** |
| 5 | Medium | 3 Medium: **#106, 113, 114** |
| **6** | **🎤 Sat — Mock #1** | **30-min mock interview** — see [`mock-interview.md`](mock-interview.md) for the prompt. 1 Easy or Medium from this topic. |
| 7 | Sunday | **Review** |
| 8 | Medium | 3 Medium: **#199, 222, 236** |
| 9 | Medium | 3 Medium: **#314, 437, 662** ✓ |
| 10 | Hard | 3 Hard: **#124, 297, 99** |
| 11 | Hard | 3 Hard: **#145, 968, 987** |
| 12 | Hard | 3 Hard: **#834, 863, 685** |
| **13** | **🎤 Sat — Mock #2** | **75-min mock interview** — see [`mock-interview.md`](mock-interview.md). 1 Medium (30 min) + 1 Hard (45 min) from this topic. |
| 14 | Hard + review | 3 Hard: **#428, 2538, 431** ✓ |


**🔁 Stretch problems** — original problems displaced by mock days. Solve on Sunday review or fit in throughout the topic:

- *Day 6 (Mock #1) — original Medium*: #116, #117, #129
- *Day 13 (Mock #2) — original Hard*: #988, #2096, #437

---

# 📕 Tier 3 — Tree / Advanced Structures

---

## Topic 13: Binary Search Tree (Weeks 25–26) — file: `topics/binary-search-tree.md`

| Day | Phase | Tasks |
|---|---|---|
| 1 | Read + Easy | Inorder = sorted; validate with bounds. 4 Easy: **#108, 235, 270, 530** |
| 2 | Easy | 5 Easy: **#538, 653, 700, 783, 897** |
| 3 | Easy | 6 Easy: **#938, 1305, 1469, 2236, 2331, 671** ✓ |
| 4 | Medium | 3 Medium: **#95, 96, 98** |
| 5 | Medium | 3 Medium: **#109, 173, 222** |
| **6** | **🎤 Sat — Mock #1** | **30-min mock interview** — see [`mock-interview.md`](mock-interview.md) for the prompt. 1 Easy or Medium from this topic. |
| 7 | Sunday | **Review** |
| 8 | Medium | 3 Medium: **#426, 449, 450** |
| 9 | Medium | 3 Medium: **#510, 701, 1382** ✓ |
| 10 | Hard | 3 Hard: **#99, 220, 315** |
| 11 | Hard | 3 Hard: **#327, 352, 493** |
| 12 | Hard | 3 Hard: **#715, 729, 731** |
| **13** | **🎤 Sat — Mock #2** | **75-min mock interview** — see [`mock-interview.md`](mock-interview.md). 1 Medium (30 min) + 1 Hard (45 min) from this topic. |
| 14 | Hard + review | 3 Hard: **#855, 2407, 2519** ✓ |


**🔁 Stretch problems** — original problems displaced by mock days. Solve on Sunday review or fit in throughout the topic:

- *Day 6 (Mock #1) — original Medium*: #230, #235, #285
- *Day 13 (Mock #2) — original Hard*: #732, #218, #2179

---

## Topic 14: Tries (Weeks 27–27.5) — file: `topics/tries.md`  *(1.5 weeks — 10 days)*

| Day | Phase | Tasks |
|---|---|---|
| 1 | Read + Easy | Trie template. 5 Easy: **#14, 720, 1268, 1023, 1858** |
| 2 | Easy | 5 Easy: **#386, 1948, 1707, 1804, 2306** |
| 3 | Easy | 5 Easy: **#1233, 2416, 2707, 3043, 720** ✓ |
| 4 | Medium | 4 Medium: **#208, 211, 421, 648** |
| 5 | Medium | 4 Medium: **#676, 677, 692, 745** |
| **6** | **🎤 Sat — Mock #1** | **30-min mock interview** — see [`mock-interview.md`](mock-interview.md) for the prompt. 1 Easy or Medium from this topic. |
| 7 | Sunday | **Review** |
| 8 | Hard | 4 Hard: **#212, 336, 425, 472** |
| 9 | Hard | 4 Hard: **#588, 642, 745, 1032** |
| 10 | Hard + review | 4 Hard: **#1166, 1803, 2227, 2416** ✓ |


**🔁 Stretch problems** — original problems displaced by mock days. Solve on Sunday review or fit in throughout the topic:

- *Day 6 (Mock #1) — original Medium*: #820, #1268, #1707, #1804

---

## Topic 15: Heaps / Priority Queue (Weeks 28–29) — file: `topics/heaps-priority-queue.md`

| Day | Phase | Tasks |
|---|---|---|
| 1 | Read + Easy | PriorityQueue min/max + top-K trick. 4 Easy: **#703, 1046, 1337, 1464** |
| 2 | Easy | 5 Easy: **#1985, 506, 2208, 2231, 2974** |
| 3 | Easy | 6 Easy: **#3066, 2558, 2099, 3264, 1962, 1845** ✓ |
| 4 | Medium | 3 Medium: **#215, 253, 264** |
| 5 | Medium | 3 Medium: **#313, 347, 373** |
| **6** | **🎤 Sat — Mock #1** | **30-min mock interview** — see [`mock-interview.md`](mock-interview.md) for the prompt. 1 Easy or Medium from this topic. |
| 7 | Sunday | **Review** |
| 8 | Medium | 3 Medium: **#632, 658, 692** |
| 9 | Medium | 3 Medium: **#767, 973, 1642** ✓ |
| 10 | Hard | 3 Hard: **#23, 218, 239** |
| 11 | Hard | 3 Hard: **#295, 358, 407** |
| 12 | Hard | 3 Hard: **#480, 502, 630** |
| **13** | **🎤 Sat — Mock #2** | **75-min mock interview** — see [`mock-interview.md`](mock-interview.md). 1 Medium (30 min) + 1 Hard (45 min) from this topic. |
| 14 | Hard + review | 3 Hard: **#786, 668, 2402** ✓ |


**🔁 Stretch problems** — original problems displaced by mock days. Solve on Sunday review or fit in throughout the topic:

- *Day 6 (Mock #1) — original Medium*: #378, #451, #621
- *Day 13 (Mock #2) — original Hard*: #759, #778, #871

---

## Topic 16: Matrix / 2D Grid (Weeks 30–31) — file: `topics/matrix-2d-grid.md`

| Day | Phase | Tasks |
|---|---|---|
| 1 | Read + Easy | dirs[][] + flood fill template. 4 Easy: **#463, 733, 766, 832** |
| 2 | Easy | 5 Easy: **#867, 999, 661, 1572, 2022** |
| 3 | Easy | 6 Easy: **#1886, 1351, 2643, 1380, 1252, 1582** ✓ |
| 4 | Medium | 3 Medium: **#36, 48, 54** |
| 5 | Medium | 3 Medium: **#59, 62, 64** |
| **6** | **🎤 Sat — Mock #1** | **30-min mock interview** — see [`mock-interview.md`](mock-interview.md) for the prompt. 1 Easy or Medium from this topic. |
| 7 | Sunday | **Review** |
| 8 | Medium | 3 Medium: **#130, 200, 240** |
| 9 | Medium | 3 Medium: **#289, 417, 994** ✓ |
| 10 | Hard | 3 Hard: **#37, 51, 85** |
| 11 | Hard | 3 Hard: **#174, 212, 296** |
| 12 | Hard | 3 Hard: **#305, 317, 329** |
| **13** | **🎤 Sat — Mock #2** | **75-min mock interview** — see [`mock-interview.md`](mock-interview.md). 1 Medium (30 min) + 1 Hard (45 min) from this topic. |
| 14 | Hard + review | 3 Hard: **#815, 864, 980** ✓ |


**🔁 Stretch problems** — original problems displaced by mock days. Solve on Sunday review or fit in throughout the topic:

- *Day 6 (Mock #1) — original Medium*: #73, #74, #79
- *Day 13 (Mock #2) — original Hard*: #407, #489, #778

---

# 🌐 Tier 4 — Graphs

---

## Topic 17: Graphs BFS / DFS (Weeks 33–34) — file: `topics/graphs-bfs-dfs.md`

| Day | Phase | Tasks |
|---|---|---|
| 1 | Read + Easy | Adjacency list + BFS/DFS templates. 4 Easy: **#463, 733, 997, 1971** |
| 2 | Easy | 5 Easy: **#2316, 2492, 2685, 1791, 1267** |
| 3 | Easy | 6 Easy: **#690, 559, 589, 590, 2924, 1971** ✓ |
| 4 | Medium | 3 Medium: **#102, 127, 130** |
| 5 | Medium | 3 Medium: **#133, 200, 207** |
| **6** | **🎤 Sat — Mock #1** | **30-min mock interview** — see [`mock-interview.md`](mock-interview.md) for the prompt. 1 Easy or Medium from this topic. |
| 7 | Sunday | **Review** |
| 8 | Medium | 3 Medium: **#417, 542, 695** |
| 9 | Medium | 3 Medium: **#785, 994, 1466** ✓ |
| 10 | Hard | 3 Hard: **#126, 269, 297** |
| 11 | Hard | 3 Hard: **#301, 332, 489** |
| 12 | Hard | 3 Hard: **#685, 749, 778** |
| **13** | **🎤 Sat — Mock #2** | **75-min mock interview** — see [`mock-interview.md`](mock-interview.md). 1 Medium (30 min) + 1 Hard (45 min) from this topic. |
| 14 | Hard + review | 3 Hard: **#924, 928, 854** ✓ |


**🔁 Stretch problems** — original problems displaced by mock days. Solve on Sunday review or fit in throughout the topic:

- *Day 6 (Mock #1) — original Medium*: #210, #261, #286
- *Day 13 (Mock #2) — original Hard*: #815, #847, #864

---

## Topic 18: Graphs Advanced — Topo / DSU / Dijkstra / MST (Weeks 35–36) — file: `topics/graphs-advanced.md`

| Day | Phase | Tasks |
|---|---|---|
| 1 | Read + Easy | All 7 sub-templates. 4 Easy: **#547, 997, 1971, 1319** |
| 2 | Easy | 5 Easy: **#2316, 2492, 2685, 1791, 1267** |
| 3 | Easy | 6 Easy: **#1101, 1102, 990, 2424, 1466, 1971** ✓ |
| 4 | Medium | 3 Medium: **#207, 210, 261** |
| 5 | Medium | 3 Medium: **#310, 323, 399** |
| **6** | **🎤 Sat — Mock #1** | **30-min mock interview** — see [`mock-interview.md`](mock-interview.md) for the prompt. 1 Easy or Medium from this topic. |
| 7 | Sunday | **Review** |
| 8 | Medium | 3 Medium: **#743, 787, 802** |
| 9 | Medium | 3 Medium: **#1091, 1584, 1631** ✓ |
| 10 | Hard | 3 Hard: **#269, 305, 332** |
| 11 | Hard | 3 Hard: **#685, 765, 778** |
| 12 | Hard | 3 Hard: **#815, 847, 864** |
| **13** | **🎤 Sat — Mock #2** | **75-min mock interview** — see [`mock-interview.md`](mock-interview.md). 1 Medium (30 min) + 1 Hard (45 min) from this topic. |
| 14 | Hard + review | 3 Hard: **#1697, 1928, 928** ✓ |


**🔁 Stretch problems** — original problems displaced by mock days. Solve on Sunday review or fit in throughout the topic:

- *Day 6 (Mock #1) — original Medium*: #547, #684, #721
- *Day 13 (Mock #2) — original Hard*: #924, #1192, #1489

---

# 🛠️ Tier 5 — Algorithm Techniques

---

## Topic 19: Greedy (Weeks 37–38) — file: `topics/greedy.md`

| Day | Phase | Tasks |
|---|---|---|
| 1 | Read + Easy | Activity selection + jump-game templates. 4 Easy: **#121, 122, 409, 455** |
| 2 | Easy | 5 Easy: **#561, 605, 860, 944, 976** |
| 3 | Easy | 6 Easy: **#1217, 1221, 1403, 1518, 1903, 2160** ✓ |
| 4 | Medium | 3 Medium: **#45, 55, 134** |
| 5 | Medium | 3 Medium: **#135, 253, 300** |
| **6** | **🎤 Sat — Mock #1** | **30-min mock interview** — see [`mock-interview.md`](mock-interview.md) for the prompt. 1 Easy or Medium from this topic. |
| 7 | Sunday | **Review** |
| 8 | Medium | 3 Medium: **#435, 452, 621** |
| 9 | Medium | 3 Medium: **#763, 767, 921** ✓ |
| 10 | Hard | 3 Hard: **#42, 135, 218** |
| 11 | Hard | 3 Hard: **#239, 330, 358** |
| 12 | Hard | 3 Hard: **#391, 502, 630** |
| **13** | **🎤 Sat — Mock #2** | **75-min mock interview** — see [`mock-interview.md`](mock-interview.md). 1 Medium (30 min) + 1 Hard (45 min) from this topic. |
| 14 | Hard + review | 3 Hard: **#871, 1326, 1675** ✓ |


**🔁 Stretch problems** — original problems displaced by mock days. Solve on Sunday review or fit in throughout the topic:

- *Day 6 (Mock #1) — original Medium*: #334, #376, #402
- *Day 13 (Mock #2) — original Hard*: #632, #757, #765

---

## Topic 20: Intervals (Weeks 39–39.5) — file: `topics/intervals.md`  *(1.5 weeks — 10 days)*

| Day | Phase | Tasks |
|---|---|---|
| 1 | Read + Easy | Sort + sweep. 5 Easy: **#252, 228, 605, 1893, 2406** |
| 2 | Easy | 5 Easy: **#1854, 2848, 1431, 1684, 1991** |
| 3 | Easy | 5 Easy: **#1356, 1929, 1700, 2410, 2554** ✓ |
| 4 | Medium | 4 Medium: **#56, 57, 253, 435** |
| 5 | Medium | 4 Medium: **#436, 452, 495, 729** |
| **6** | **🎤 Sat — Mock #1** | **30-min mock interview** — see [`mock-interview.md`](mock-interview.md) for the prompt. 1 Easy or Medium from this topic. |
| 7 | Sunday | **Review** |
| 8 | Medium + Hard | 3 Medium: **#1851, 2406, 2580** + 1 Hard: **#218** |
| 9 | Hard | 4 Hard: **#352, 715, 732, 757** |
| 10 | Hard + review | 6 Hard: **#759, 850, 1024, 1109, 1326, 2402** + **#2503, 2589, 2271, 2251** ✓ |


**🔁 Stretch problems** — original problems displaced by mock days. Solve on Sunday review or fit in throughout the topic:

- *Day 6 (Mock #1) — original Medium*: #731, #763, #986, #1288

---

## Topic 21: Bit Manipulation (Weeks 40–40.5) — file: `topics/bit-manipulation.md`  *(1.5 weeks — 10 days)*

| Day | Phase | Tasks |
|---|---|---|
| 1 | Read + Easy | All bit tricks. 5 Easy: **#136, 191, 190, 231, 268** |
| 2 | Easy | 5 Easy: **#338, 342, 389, 401, 461** |
| 3 | Easy | 5 Easy: **#476, 693, 762, 1009, 1486** ✓ |
| 4 | Medium | 4 Medium: **#78, 137, 187, 201** |
| 5 | Medium | 4 Medium: **#260, 318, 371, 421** |
| **6** | **🎤 Sat — Mock #1** | **30-min mock interview** — see [`mock-interview.md`](mock-interview.md) for the prompt. 1 Easy or Medium from this topic. |
| 7 | Sunday | **Review** |
| 8 | Medium + Hard | 3 Medium: **#1442, 1310, 1404** + 2 Hard: **#982, 1125** |
| 9 | Hard | 4 Hard: **#1255, 1434, 1542, 1601** |
| 10 | Hard + review | 9 Hard: **#1659, 1707, 1803, 1879, 1986, 2002, 2151, 2305, 2741** ✓ |


**🔁 Stretch problems** — original problems displaced by mock days. Solve on Sunday review or fit in throughout the topic:

- *Day 6 (Mock #1) — original Medium*: #477, #540, #784, #1239

---

## Topic 22: Math & Number Theory (Weeks 41–42) — file: `topics/math-and-number-theory.md`

| Day | Phase | Tasks |
|---|---|---|
| 1 | Read + Easy | GCD/LCM/sieve/fast-pow. 4 Easy: **#7, 9, 13, 66** |
| 2 | Easy | 5 Easy: **#67, 69, 168, 171, 172** |
| 3 | Easy | 6 Easy: **#202, 204, 263, 326, 415, 1232** ✓ |
| 4 | Medium | 3 Medium: **#8, 12, 29** |
| 5 | Medium | 3 Medium: **#43, 50, 60** |
| **6** | **🎤 Sat — Mock #1** | **30-min mock interview** — see [`mock-interview.md`](mock-interview.md) for the prompt. 1 Easy or Medium from this topic. |
| 7 | Sunday | **Review** |
| 8 | Medium | 3 Medium: **#372, 384, 398** |
| 9 | Medium | 3 Medium: **#470, 539, 1006** ✓ |
| 10 | Hard | 3 Hard: **#149, 224, 233** |
| 11 | Hard | 3 Hard: **#273, 296, 391** |
| 12 | Hard | 3 Hard: **#458, 587, 829** |
| **13** | **🎤 Sat — Mock #2** | **75-min mock interview** — see [`mock-interview.md`](mock-interview.md). 1 Medium (30 min) + 1 Hard (45 min) from this topic. |
| 14 | Hard + review | 3 Hard: **#753, 932, 770** ✓ |


**🔁 Stretch problems** — original problems displaced by mock days. Solve on Sunday review or fit in throughout the topic:

- *Day 6 (Mock #1) — original Medium*: #96, #166, #365
- *Day 13 (Mock #2) — original Hard*: #891, #902, #952

---

# 🏆 Tier 6 — Hardest Last

---

## Topic 23: Dynamic Programming (Weeks 43–45) — file: `topics/dynamic-programming.md`  *(3 weeks — 21 days)*

> **Allocate extra time** here. DP is the toughest topic. Read each pattern in `patterns/fibonacci-dp.md`, `patterns/0-1-knapsack.md`, `patterns/unbounded-knapsack.md`, `patterns/lcs-dp.md`, `patterns/palindrome-dp.md`, `patterns/matrix-dp.md` before solving.

### Week 43 — Easy + first half of Medium
| Day | Tasks |
|---|---|
| 1 | Read DP intro + Fibonacci pattern. 4 Easy: **#53, 70, 118, 119** |
| 2 | 5 Easy: **#121, 198, 256, 338, 392** |
| 3 | 6 Easy: **#509, 746, 1025, 1137, 1646, 1869** ✓ Easy done |
| 4 | Read 0/1 + Unbounded knapsack pattern. 2 Medium: **#322, 518** |
| 5 | 3 Medium: **#416, 494, 264** |
| 6 | **🎤 Sat — Mock #1** | **30-min mock interview** — see [`mock-interview.md`](mock-interview.md). 1 Easy or 1 Medium DP problem. |
| 7 | **Sunday review** |

### Week 44 — Rest of Medium + start Hard
| Day | Tasks |
|---|---|
| 8 | Read LCS + Palindrome patterns. 3 Medium: **#5, 91, 139** |
| 9 | 3 Medium: **#152, 213, 300** |
| 10 | 3 Medium: **#516** + start Hard: **#72, 97** |
| 11 | 3 Hard: **#10, 32, 44** |
| 12 | 3 Hard: **#115, 123, 132** |
| 13 | **🎤 Sat — Mock #2** | **75-min mock interview** — see [`mock-interview.md`](mock-interview.md). 1 Medium DP + 1 Hard DP problem. |
| 14 | **Sunday review** |

### Week 45 — Finish Hard + retro
| Day | Tasks |
|---|---|
| 15 | 3 Hard: **#354, 410, 446** |
| 16 | 1 Hard deep dive: **#887 Super Egg Drop** |
| 17 | Redo any 3 Hard from your `[~]` list |
| 18 | Redo 3 more |
| 19 | Re-solve **#10, 72, 312** cold (no notes) |
| 20 | **🎤 Sat — Mock #3** | **90-min final DP mock** — see [`mock-interview.md`](mock-interview.md). 2 Hard DP problems back-to-back (45 min each). |
| 21 | **DP topic retrospective** ✓ |

**🔁 Stretch problems** — original problems displaced by mock days. Solve on Sunday review or fit in throughout the topic:

- *Day 6 (Mock #1) — original Medium*: #62, #63, #64
- *Day 13 (Mock #2) — original Hard*: #174, #188, #312
- *Day 20 (Mock #3) — original Hard re-solve*: #5, #132, #174

---

## Topic 24: Design & System Data Structures (Weeks 46–47) — file: `topics/design-and-system-data-structures.md`

| Day | Phase | Tasks |
|---|---|---|
| 1 | Read + Easy | LRU template + DLL skeleton. 4 Easy: **#155, 225, 232, 705** |
| 2 | Easy | 5 Easy: **#706, 933, 1603, 1656, 2241** |
| 3 | Easy | 6 Easy: **#2502, 2353, 1396, 1845, 2526, 379** ✓ |
| 4 | Medium | 3 Medium: **#146, 173, 208** |
| 5 | Medium | 3 Medium: **#211, 271, 284** |
| **6** | **🎤 Sat — Mock #1** | **30-min mock interview** — see [`mock-interview.md`](mock-interview.md) for the prompt. 1 Easy or Medium from this topic. |
| 7 | Sunday | **Review** |
| 8 | Medium | 3 Medium: **#362, 380, 535** |
| 9 | Medium | 3 Medium: **#622, 641, 1166** ✓ |
| 10 | Hard | 3 Hard: **#295, 297, 432** |
| 11 | Hard | 3 Hard: **#460, 588, 642** |
| 12 | Hard | 3 Hard: **#715, 716, 895** |
| **13** | **🎤 Sat — Mock #2** | **75-min mock interview** — see [`mock-interview.md`](mock-interview.md). 1 Medium (30 min) + 1 Hard (45 min) from this topic. |
| 14 | Hard + review | 3 Hard: **#1825, 1912, 381** ✓ |


**🔁 Stretch problems** — original problems displaced by mock days. Solve on Sunday review or fit in throughout the topic:

- *Day 6 (Mock #1) — original Medium*: #348, #355, #359
- *Day 13 (Mock #2) — original Hard*: #1206, #1622, #1670

---

# 🎯 Week 48 — Final Integration

You've solved every problem in the repo (~1,000 unique problems).

| Day | Task |
|---|---|
| Mon | **Mock interview #1** — 1 random Medium (30 min) + 1 Hard (45 min) |
| Tue | **Mock interview #2** — different topics from Mon |
| Wed | **Mock #3** — focus on your 2 weakest topics from retrospectives |
| Thu | **Mock #4** — company-tagged (Amazon / Google / Meta) |
| Fri | **Mock #5** — company-tagged |
| Sat | List your top 20 "must-redo before next interview" problems |
| Sun | **Final retrospective.** Update your resume. Start applying. |

---

## Progress tracking

```bash
cd /Users/y0p03mn/preparation/coding-revision/interview-prep
done=$(grep -rh '\[x\]' topics/ patterns/ | wc -l)
partial=$(grep -rh '\[~\]' topics/ patterns/ | wc -l)
total=$(grep -rhE '\[( |~|x)\]' topics/ patterns/ | wc -l)
echo "Done: $done / $total | Partial: $partial"
```

### Per-topic checkpoints
After each topic, ask:
1. Can I write the topic's templates **from memory**?
2. Solve rate ≥ 70% Easy, ≥ 50% Medium, ≥ 30% Hard?
3. Can I recognize the topic's patterns from cheatsheet keywords?

If **no** to any → don't move on. Add a 3-day re-do mini-week before the next topic.

---

## Rules of survival

- **One topic at a time.** Don't peek ahead.
- **Stretch hard topics.** If a topic is taking 3 weeks instead of 2, that's OK. Don't rush.
- **Skip a Hard only after 90 minutes.** Mark `[~]` and revisit at the end of the topic.
- **Sunday is sacred.** No new problems. Only redo & review.
- **Talk through your solution out loud** for at least 1 problem/day — interview muscle.

Good luck. The discipline of finishing a topic completely is rare and powerful. Start with Topic 1, Day 1.

