# 8-Week NeetCode 150 Interview Preparation Plan

> **Target:** Become interview-ready for Senior Backend Java/Spring Boot coding rounds by mastering the NeetCode 150 patterns, not by memorising solutions.
>
> **Duration:** 8 weeks  
> **Cadence:** 2 hours on weekdays + 4 hours on Saturday/Sunday  
> **Core set:** NeetCode 150 — 150 problems, currently 28 Easy / 101 Medium / 21 Hard across 18 categories.  
> **Primary source:** https://neetcode.io/practice/practice/neetcode150
>
> NeetCode describes the 150 as the Blind 75 plus 75 additional problems and positions it for candidates already familiar with basic data structures and algorithms. The official page currently shows 28 Easy, 101 Medium and 21 Hard, so this plan follows the actual NeetCode 150 distribution instead of artificially forcing the same number of Easy/Medium/Hard questions into every topic.

---

## 1. The New Strategy

The old plan was topic-balanced: 10 questions per topic. That is useful for coverage, but it does not match the shape of real interviews or the NeetCode roadmap.

This plan uses **NeetCode 150 as the backbone** and adds three things around it:

1. **First-pass pattern learning** — solve the problems in NeetCode order.
2. **Spaced re-solving** — revisit failures and high-value patterns instead of repeatedly counting new problems.
3. **Interview simulation** — start mocks before finishing all 150 so the ability to solve under pressure develops alongside the knowledge.

The goal is not:

> "I completed 150 LeetCode questions."

The goal is:

> "Give me an unfamiliar Medium problem, and I can identify the likely pattern, explain the approach, code it in Java, prove correctness, discuss complexity, and handle follow-up constraints."

---

## 2. Success Standard

At the end of Week 8, target these benchmarks:

| Skill | Target |
|---|---|
| NeetCode 150 first pass | 150/150 attempted |
| Independent solves | >=80% of Easy/Medium review questions |
| Unseen Medium pattern recognition | <=5 minutes |
| Unseen Medium coding | ~20-25 minutes |
| Hard problems | Understand and independently reproduce the core approach for the majority attempted |
| Java implementation | Comfortable with collections, recursion, trees, graphs, heaps, custom comparators and generics |
| Complexity | State time + space without prompting |
| Communication | Explain brute force -> optimisation -> final approach clearly |
| Mock performance | >=70% of mock score before calling DSA interview-ready |
| Weak-pattern recovery | Can identify why a failed solution failed and solve it again later |

**Important:** Finishing the list without meeting these benchmarks does not count as interview readiness.

---

## 3. NeetCode 150 Coverage

The current official roadmap contains 18 categories:

| # | Category | Problems |
|---:|---|---:|
| 1 | Arrays & Hashing | 9 |
| 2 | Two Pointers | 5 |
| 3 | Sliding Window | 6 |
| 4 | Stack | 6 |
| 5 | Binary Search | 7 |
| 6 | Linked List | 11 |
| 7 | Trees | 15 |
| 8 | Heap / Priority Queue | 7 |
| 9 | Backtracking | 10 |
| 10 | Tries | 3 |
| 11 | Graphs | 13 |
| 12 | Advanced Graphs | 6 |
| 13 | 1-D Dynamic Programming | 12 |
| 14 | 2-D Dynamic Programming | 11 |
| 15 | Greedy | 8 |
| 16 | Intervals | 6 |
| 17 | Math & Geometry | 8 |
| 18 | Bit Manipulation | 7 |
| | **Total** | **150** |

Difficulty distribution on the current official page: **28 Easy + 101 Medium + 21 Hard = 150**.

Use the official NeetCode page as the authoritative problem inventory and direct LeetCode links. Do not substitute a similarly named problem from another list.

---

# 4. Eight-Week Roadmap

## Week 1 — Foundations: Arrays, Hashing, Two Pointers, Sliding Window

**Primary objective:** Build the pattern-recognition foundation used throughout the rest of the roadmap.

| Day | New Work | Revision / Interview Work | Mark Done |
|---|---|---|---|
| Mon | Arrays & Hashing — first 3 problems | Learn hash map/set patterns | [ ] |
| Tue | Arrays & Hashing — next 3 | Re-solve 1 weak problem | [ ] |
| Wed | Arrays & Hashing — final 3 | Explain all 9 patterns verbally | [ ] |
| Thu | Two Pointers — all 5 | Timed re-solve of 2 array problems | [ ] |
| Fri | Sliding Window — first 3 | Pattern drill: fixed vs variable window | [ ] |
| Sat | Sliding Window — final 3 | 60-min mini mock + review | [ ] |
| Sun | **No major new problems** | Weekly revision + error log + 2 timed re-solves | [ ] |

**Week 1 target:** 23 new problems.

### Patterns to master
- HashSet / HashMap lookup
- Frequency counting
- Prefix/suffix reasoning
- Sorting as a simplification technique
- Two-pointer invariant
- Fixed-size sliding window
- Variable-size sliding window

### Interview checkpoint
You should be able to recognise a two-pointer or sliding-window problem from the wording before writing code.

---

## Week 2 — Stack, Binary Search, Linked List

**Primary objective:** Master stateful traversal and search-space reduction.

| Day | New Work | Revision / Interview Work | Mark Done |
|---|---|---|---|
| Mon | Stack category | Re-solve 2 Week-1 failures | [ ] |
| Tue | Binary Search — first 4 | Binary-search invariant drill | [ ] |
| Wed | Binary Search — final 3 | Timed binary-search problem | [ ] |
| Thu | Linked List — first 4 | Pointer movement drill | [ ] |
| Fri | Linked List — next 4 | Re-solve one failed linked-list problem | [ ] |
| Sat | Linked List — final 3 | 45-min mock: stack/search/list | [ ] |
| Sun | **No major new problems** | Weekly revision + error log | [ ] |

**Week 2 target:** 22 new problems; cumulative ~45.

### Patterns to master
- Monotonic stack / next greater element
- Stack simulation
- Binary search on sorted data
- Binary search on answer space
- Fast/slow pointers
- In-place linked-list reversal
- Cycle detection
- Merge/reorder linked lists

### Interview checkpoint
Given an unfamiliar problem, explain **why binary search is valid** before writing the binary-search loop.

---

## Week 3 — Trees, Tries, Heap / Priority Queue

**Primary objective:** Become fluent with recursive tree reasoning and priority-based processing.

| Day | New Work | Revision / Interview Work | Mark Done |
|---|---|---|---|
| Mon | Trees — first 4 | DFS recursion template | [ ] |
| Tue | Trees — next 4 | BFS/level-order template | [ ] |
| Wed | Trees — next 4 | BST vs generic tree distinction | [ ] |
| Thu | Trees — final 3 | Re-solve hardest failed tree problem | [ ] |
| Fri | Tries — all 3 | Trie implementation from memory | [ ] |
| Sat | Heap/PQ — all 7 | 60-min mock + Java PriorityQueue drill | [ ] |
| Sun | **No major new problems** | Tree/heap mixed revision | [ ] |

**Week 3 target:** 25 new problems; cumulative ~70.

### Patterns to master
- Recursive DFS
- Iterative DFS/BFS
- Tree height / diameter
- Lowest common ancestor
- BST invariants
- Serialization/deserialization
- Trie insert/search/prefix
- Min-heap / max-heap
- Top-K
- Two-heaps / streaming median

### Senior Java requirement
Implement tree traversal, Trie and heap-based solutions cleanly in Java without relying on IDE autocomplete for the core logic.

---

## Week 4 — Backtracking + Graphs

**Primary objective:** Make recursion, state-space search and graph traversal automatic.

| Day | New Work | Revision / Interview Work | Mark Done |
|---|---|---|---|
| Mon | Backtracking — first 5 | Backtracking decision-tree drill | [ ] |
| Tue | Backtracking — remaining 5 | Re-solve one combination/permutation problem | [ ] |
| Wed | Graphs — first 4 | BFS vs DFS decision drill | [ ] |
| Thu | Graphs — next 4 | Visited-state modelling | [ ] |
| Fri | Graphs — final 5 | Topological sort / Union-Find review | [ ] |
| Sat | **Half-day new work + full mock** | 75-min graph/backtracking mock | [ ] |
| Sun | **No major new problems** | Weeks 1–4 mixed revision | [ ] |

**Week 4 target:** 27 new problems; cumulative ~97.

### Patterns to master
- Choose / explore / undo
- Duplicate handling in backtracking
- Grid DFS/BFS
- Graph adjacency list
- Connected components
- Cycle detection
- Bipartite reasoning
- Topological sort
- Union-Find / DSU

### Interview checkpoint
You should be able to convert a story into a graph model: **nodes, edges, direction, weight, visited state**.

---

## Week 5 — Advanced Graphs + 1-D DP

**Primary objective:** Learn the two areas where senior candidates often lose time: weighted graphs and dynamic programming.

| Day | New Work | Revision / Interview Work | Mark Done |
|---|---|---|---|
| Mon | Advanced Graphs — first 3 | Dijkstra / MST comparison | [ ] |
| Tue | Advanced Graphs — final 3 | Topological/weighted graph drill | [ ] |
| Wed | 1-D DP — first 4 | DP state-definition drill | [ ] |
| Thu | 1-D DP — next 4 | Re-solve one failed DP problem | [ ] |
| Fri | 1-D DP — final 4 | Recurrence -> memo -> tabulation | [ ] |
| Sat | 90-min DP/graph mock | Review every mistake | [ ] |
| Sun | **No major new problems** | Mixed revision | [ ] |

**Week 5 target:** 18 new problems; cumulative ~115.

### DP framework
For every DP problem explicitly answer:

1. What does `dp[i]` or `dp[i][j]` mean?
2. What choices are available?
3. What is the transition?
4. What are the base cases?
5. What is the iteration order?
6. Can space be reduced?

### Graph framework
Know when to use:
- BFS
- DFS
- Topological sort
- Union-Find
- Dijkstra
- Prim/Kruskal
- Modified shortest path / state-space search

---

## Week 6 — 2-D DP + Greedy + Intervals

**Primary objective:** Handle multi-dimensional state and prove greedy choices.

| Day | New Work | Revision / Interview Work | Mark Done |
|---|---|---|---|
| Mon | 2-D DP — first 4 | Grid DP state drill | [ ] |
| Tue | 2-D DP — next 4 | String DP drill | [ ] |
| Wed | 2-D DP — final 3 | Re-solve hardest DP failure | [ ] |
| Thu | Greedy — all 8 | Greedy proof / counterexample drill | [ ] |
| Fri | Intervals — all 6 | Sorting + interval invariant | [ ] |
| Sat | 90-min mixed mock | DP + greedy + intervals | [ ] |
| Sun | **No major new problems** | Full Weeks 1–6 revision | [ ] |

**Week 6 target:** 21 new problems; cumulative ~136.

### Patterns to master
- Grid DP
- LCS/edit-distance style state
- Knapsack-style transitions
- Interval sorting
- Merge/overlap
- Scheduling
- Greedy invariant
- Proving why a local choice is safe

### Interview checkpoint
Do not say "greedy works because it seems optimal." State the invariant or exchange argument that makes the choice safe.

---

## Week 7 — Math, Geometry, Bit Manipulation + Completion

**Primary objective:** Finish the remaining NeetCode problems while preserving time for re-solves.

| Day | New Work | Revision / Interview Work | Mark Done |
|---|---|---|---|
| Mon | Math & Geometry — first 4 | Re-solve 2 weak Mediums | [ ] |
| Tue | Math & Geometry — final 4 | Matrix manipulation drill | [ ] |
| Wed | Bit Manipulation — all 7 | XOR / bit-mask drill | [ ] |
| Thu | **NeetCode catch-up day** | Finish any missed problems | [ ] |
| Fri | **Failure-day** | Re-solve 5 previously failed problems | [ ] |
| Sat | Full 90-min coding mock | Deep review | [ ] |
| Sun | **150 completion audit** | Categorise Green / Yellow / Red | [ ] |

**Week 7 target:** Finish all 150 first-pass attempts.

### Completion audit
For every problem mark:

- **Green:** solved independently within target time.
- **Yellow:** needed a hint or solution but can now reproduce it.
- **Red:** cannot reproduce the approach without help.

Do not treat Yellow/Red as completed mastery.

---

# Week 8 — Interview Readiness Week

**Objective:** Stop accumulating new problems. Convert knowledge into interview performance.

| Day | Focus | Work | Mark Done |
|---|---|---|---|
| Mon | Arrays / Hashing / Two Pointers | 4 unseen Mediums + 2 re-solves | [ ] |
| Tue | Sliding Window / Stack / Binary Search | 4 unseen Mediums + 2 re-solves | [ ] |
| Wed | Linked List / Trees / Heap | 4 unseen Mediums + 2 re-solves | [ ] |
| Thu | Backtracking / Graphs | 3 unseen Mediums + 2 re-solves | [ ] |
| Fri | DP / Greedy / Intervals | 3 unseen Mediums + 2 re-solves | [ ] |
| Sat | **Full 60–75 min mock** | Two-round simulation + review | [ ] |
| Sun | **Final assessment** | Weak-pattern repair + interview checklist | [ ] |

**Week 8 target:** No meaningful new-list expansion. Focus on transfer and speed.

---

# 5. Daily 2-Hour Operating System

## Weekday session

### Block 1 — 10 min: Recall
Without looking at notes:
- What patterns did I learn yesterday?
- What was the key invariant?
- What mistake did I make?

### Block 2 — 35 min: Primary problem
Attempt the problem cold.

Rules:
- No solution video initially.
- No searching for the exact problem.
- State brute force first.
- Find the bottleneck.
- Derive the optimal pattern.

### Block 3 — 35 min: Second problem
Same process, but target faster pattern recognition.

### Block 4 — 25 min: Re-solve / review
Pick one previously failed problem and solve from a blank editor.

### Block 5 — 15 min: Interview explanation
Verbally explain:
1. Problem interpretation
2. Brute force
3. Why brute force is insufficient
4. Optimal approach
5. Correctness intuition
6. Complexity
7. Edge cases

---

# 6. Saturday 4-Hour Structure

| Block | Duration | Activity |
|---|---:|---|
| A | 90 min | New NeetCode problems |
| B | 90 min | 2-question real-time mock interview |
| C | 30 min | Mock review + scorecard |
| D | 30 min | Re-solve failures / mistake-log revision |

Saturday is **not** just another high-volume LeetCode day. The mock is mandatory.

---

# 7. Sunday Revision System

Sunday is deliberately lighter on new material.

### Spaced repetition schedule

For every important problem:

- **T0:** Initial solve
- **T+1 day:** Explain approach without code
- **T+3 days:** Re-solve if Yellow/Red
- **T+7 days:** Timed re-solve
- **T+14 days:** Random mixed recall
- **Week 8:** Interview-style re-solve

### Sunday checklist

- [ ] Review error log
- [ ] Re-solve 4–6 Yellow/Red problems
- [ ] Revisit one major pattern cheat sheet
- [ ] Do one timed unseen Medium
- [ ] Update category score
- [ ] Decide next week's weak patterns

---

# 8. ChatGPT Hardcore Interview Mode

Use ChatGPT as the interviewer, not as the answer generator.

## Interview rules

1. Give me only the problem statement.
2. Do not tell me the pattern.
3. Ask one interviewer question at a time.
4. Let me explain my approach before coding.
5. Do not give a hint unless I have made a genuine attempt.
6. If I am stuck, give the smallest useful hint.
7. After coding, review correctness and edge cases.
8. Ask for time and space complexity.
9. Give at least one follow-up constraint.
10. Ask me to modify the solution.
11. Score communication separately from correctness.
12. Record the mistake for later spaced revision.

## Senior-level follow-ups

Depending on the problem, ask:

- What happens with 10x input size?
- Can we reduce memory?
- What if the data is streaming?
- What if the input does not fit in memory?
- What if operations are concurrent?
- What if we need thread safety?
- What if the API receives duplicate events?
- What if latency is more important than throughput?
- What if the data is distributed?
- Can we trade memory for latency?
- What invariant guarantees correctness?

The purpose is to bridge **DSA knowledge -> senior engineering reasoning**.

---

# 9. Daily Interview Format / Operating Rules

This is the **mandatory format for every weekday problem session**. When I paste a problem, ChatGPT should use this section as the operating contract before I write code on LeetCode.

## Step 1 — Clarify Requirements

- I explain what I understand from the problem.
- ChatGPT asks interviewer-style clarification questions one at a time.
- We confirm constraints, input/output assumptions, duplicates, ordering, empty input and other relevant edge conditions.
- **No solution or pattern is revealed at this stage.**

## Step 2 — My Initial Approach

- I propose the first approach.
- I explain the intuition before coding.
- I state expected time and space complexity.
- ChatGPT challenges the reasoning rather than immediately correcting it.

## Step 3 — Brute Force

- I explicitly describe the simplest correct solution.
- We identify its bottleneck.
- I explain why that complexity may or may not be acceptable under the constraints.

## Step 4 — Optimization Discussion

- ChatGPT asks questions that help me discover the optimization.
- Hints are given only after a genuine attempt and only at the smallest useful level.
- We compare candidate approaches and their trade-offs.
- We identify the key invariant / observation.

## Step 5 — Final Algorithm

Before coding, I must state:

1. Final approach
2. Core intuition
3. Algorithm steps
4. Correctness reasoning / invariant
5. Time complexity
6. Space complexity
7. Important edge cases

## Step 6 — Code on LeetCode

- I implement the agreed solution myself on LeetCode in Java.
- ChatGPT does **not** write the solution for me unless explicitly requested after the attempt.
- If the code fails, I first debug and explain the failure myself.

## Step 7 — Code Review

After I paste the LeetCode code/result, ChatGPT reviews:

- Correctness
- Edge cases
- Time complexity
- Space complexity
- Java collections / APIs
- Readability and maintainability
- Unnecessary work or allocations
- Opportunities for a cleaner implementation

## Step 8 — Senior-Level Follow-ups

After the base solution is final, ChatGPT may challenge me with realistic senior-engineering constraints such as:

- What if input size becomes 10x larger?
- What if data is streaming?
- What if the input cannot fit in memory?
- What if calls are concurrent?
- How would you make it thread-safe?
- What if duplicate events arrive?
- What if latency matters more than throughput?
- What if the data is distributed?
- Can we trade memory for latency?
- What invariant guarantees correctness?

### Golden Rule

**Do not jump to the solution.** The objective is to train independent problem solving, pattern recognition, communication and senior-level reasoning.

---

# 10. Weekend Real-Time Mock Interview Format

Every weekend we conduct a **real interview-style mock with exactly 2 coding questions**. The mock is separate from normal weekday problem discussion.

## Mock Rules

- 2 questions
- Real interviewer behaviour
- No pattern hints
- No solution nudges unless the interview format requires them
- Clarification questions are expected from me
- I must explain the approach before coding
- ChatGPT may interrupt, challenge assumptions and ask follow-ups
- Time pressure is simulated
- Both questions are scored independently

## Mock Flow

### Question 1

- Problem statement only
- Clarification
- Approach
- Brute force
- Optimization
- Final algorithm
- Java implementation
- Tests / edge cases
- Complexity
- Follow-up

### Question 2

Same process, but **no assistance based on Question 1**.

## Mock Scorecard

| Area | Score | Notes |
|---|---:|---|
| Clarification | /10 | |
| Problem decomposition | /10 | |
| Algorithm | /10 | |
| Java implementation | /10 | |
| Correctness | /10 | |
| Edge cases | /10 | |
| Complexity | /10 | |
| Communication | /10 | |
| Follow-up handling | /10 | |
| **Total** | **/90** | |

## Hiring Recommendation

At the end of the mock, ChatGPT gives one of:

- ❌ **Not Ready**
- 🟡 **Borderline**
- 🟢 **Hire**
- ⭐ **Strong Hire**

The feedback must identify the top strengths, top weaknesses and the highest-priority revision topics.

---

# 11. Daily Mistake Tracking

Maintain this table throughout the 8-week program. Every meaningful mistake from our problem discussions and weekend mocks should be recorded here.

| Date | Problem | Pattern | Mistake | Next Revision | Status |
|---|---|---|---|---|---|
| | | | | | |
| | | | | | |
| | | | | | |
| | | | | | |
| | | | | | |
| | | | | | |
| | | | | | |
| | | | | | |

### Example

| Date | Problem | Pattern | Mistake | Next Revision | Status |
|---|---|---|---|---|---|
| Example | Sliding Window problem | Sliding Window | Missed shrinking condition | 3 days | Yellow |

### Mistake Categories

Use one of these tags when useful:

- `PATTERN_MISS`
- `LOGIC_ERROR`
- `EDGE_CASE`
- `IMPLEMENTATION`
- `COMPLEXITY`
- `JAVA_API`
- `TIME_PRESSURE`
- `COMMUNICATION`

## Weekend Revision Rule

Every weekend mock/revision session must first inspect this mistake log. The highest-priority Yellow/Red mistakes and overdue revisions determine what we revisit.

Priority order:

1. Repeated mistake in the same pattern
2. Overdue revision
3. Mistake that caused a wrong algorithm
4. Implementation / Java mistake
5. Communication or complexity mistake

**The mistake log is the source of truth for weekend revision.**

---

# 12. Error Log

Keep this table updated throughout the 8 weeks.

| Date | Problem | Pattern | Mistake | Correct Insight | Revisit | Status |
|---|---|---|---|---|---|---|
| | | | | | | |
| | | | | | | |
| | | | | | | |
| | | | | | | |
| | | | | | | |

### Mistake categories

Use one of these tags:

- `PATTERN_MISS`
- `LOGIC_ERROR`
- `EDGE_CASE`
- `IMPLEMENTATION`
- `COMPLEXITY`
- `JAVA_API`
- `TIME_PRESSURE`
- `COMMUNICATION`

---

# 13. Weekly Scorecard

| Week | New Problems | Re-solves | Mock | Unseen Mediums | Weakest Pattern | Score |
|---:|---:|---:|---:|---:|---|---:|
| 1 | 23 | | 1 | | | |
| 2 | 22 | | 1 | | | |
| 3 | 25 | | 1 | | | |
| 4 | 27 | | 1 | | | |
| 5 | 18 | | 1 | | | |
| 6 | 21 | | 1 | | | |
| 7 | 14* | | 1 | | | |
| 8 | 0 | | 2 | 17+ | | |

`*` Week 7 is a catch-up/completion target; actual count depends on progress in Weeks 1–6.

**Important:** The weekly new-problem numbers are a pacing guide, not permission to skip a problem or mark an unfinished problem as complete.

---

# 14. Adaptive Rules

### If performance is below 60%

- Stop increasing new-problem volume.
- Re-solve foundational Easy/Medium problems.
- Add one extra revision block.
- Use hints earlier after a genuine attempt.
- Delay Hard problems until the underlying pattern is stable.

### If performance is 60–80%

- Continue the plan.
- Keep the current new-problem pace.
- Increase timed Medium practice.
- Revisit Yellow problems after 3–7 days.

### If performance is above 80%

- Reduce time spent on Easy problems.
- Increase unseen Mediums.
- Add Hard follow-ups.
- Increase mock frequency.
- Focus on communication and optimisation rather than raw problem count.

---

# 15. What Counts as "Solved"

A problem is **not** complete just because the code was accepted.

### Green — Mastered

- Solved without external help.
- Correct within target time.
- Can explain the invariant.
- Can state complexity.
- Can handle edge cases.
- Can reproduce it later.

### Yellow — Learned

- Needed a hint or editorial.
- Understands the approach.
- Can reproduce the solution after review.
- Requires another spaced re-solve.

### Red — Not Learned

- Cannot derive the approach.
- Cannot explain why the solution works.
- Cannot reproduce it later.

Only **Green** should be treated as interview-ready mastery.

---

# 16. Java Interview Checklist

For every implementation, practise the Java-specific details that frequently cause avoidable mistakes:

- [ ] `HashMap`
- [ ] `HashSet`
- [ ] `ArrayList`
- [ ] `Deque` / `ArrayDeque`
- [ ] `PriorityQueue`
- [ ] Custom `Comparator`
- [ ] Sorting arrays and collections
- [ ] StringBuilder
- [ ] Character/int conversions
- [ ] Recursion and stack depth
- [ ] TreeNode/ListNode handling
- [ ] Graph adjacency lists
- [ ] BFS queues
- [ ] DFS visited sets
- [ ] Union-Find
- [ ] Memoization maps/arrays
- [ ] 2-D arrays
- [ ] Integer overflow awareness

The objective is to spend interview time thinking about the algorithm, not remembering Java collection syntax.

---

# 17. Mock Interview Progression

**Every weekend = exactly 2 questions.** The difficulty and focus increase as the weeks progress.

## Mock 1 — End of Week 1

- 2 questions: Easy + Medium
- 90 minutes
- Focus: communication, clarification and pattern recognition

## Mock 2 — End of Week 2

- 2 Medium questions
- 90 minutes
- Focus: stack / binary search / linked list

## Mock 3 — End of Week 3

- 2 Medium questions + follow-ups
- 90 minutes
- Focus: trees / heap / Trie

## Mock 4 — End of Week 4

- 2 Medium questions
- 90 minutes
- Focus: graph / backtracking

## Mock 5 — End of Week 5

- 2 Medium questions + DP follow-up
- 90 minutes
- Focus: advanced graph / dynamic programming reasoning

## Mock 6 — End of Week 6

- 2 mixed Medium questions + optimisation follow-ups
- 90 minutes
- Focus: DP / greedy / intervals

## Mock 7 — End of Week 7

- 2 mixed Medium questions
- 90 minutes
- Full coding-round simulation

## Mock 8 — Week 8 Final

- 2 mixed interview questions
- 90 minutes
- No pattern hints
- Interviewer interruptions and follow-ups
- Final readiness score + hiring recommendation

**Mock rule:** I should behave like a real interviewer and should not reveal the underlying pattern. If a hint is genuinely necessary, it should be minimal and reflected in the final score.

---

# 18. Final DSA Readiness Gate

Before declaring DSA complete, pass all of these:

### Pattern recognition
- [ ] Can identify common pattern within ~5 minutes.
- [ ] Can explain why that pattern applies.

### Coding
- [ ] Can code most unseen Mediums within ~20–25 minutes.
- [ ] Can produce clean Java without excessive debugging.

### Correctness
- [ ] Can state invariant or reasoning.
- [ ] Can identify edge cases before running code.

### Complexity
- [ ] Can give accurate time complexity.
- [ ] Can give accurate space complexity.
- [ ] Can explain optimisation trade-offs.

### Interview behaviour
- [ ] Thinks aloud clearly.
- [ ] Clarifies ambiguous requirements.
- [ ] Does not jump directly into coding.
- [ ] Responds well to interviewer follow-ups.

### Mock performance
- [ ] At least 2 consecutive mocks >=70%.
- [ ] No recurring `PATTERN_MISS` on the same major topic.
- [ ] Can recover from a wrong initial approach without interviewer giving the solution.

---

# 19. What Comes After NeetCode 150

Completing this plan makes the **coding/DSA track** strong. It does not complete the entire Senior Backend interview.

After Week 8, preparation should shift toward:

1. **LLD** — object modelling, SOLID, design patterns, concurrency-aware design.
2. **HLD/System Design** — scalable services, Kafka, caching, databases, consistency, reliability and observability.
3. **Java/Spring Boot** — JVM, concurrency, Spring internals, transactions, reactive programming, performance.
4. **Backend architecture** — microservices, distributed systems, API design and failure handling.
5. **Behavioural** — leadership, ownership, conflict, incident handling and project impact.
6. **Company-specific coding** — after the core patterns are stable.

For a Senior Backend candidate, NeetCode 150 should make the coding round a strength, while LLD/HLD/Java/backend depth determine the rest of the interview outcome.

---

# 20. Official Resource

**NeetCode 150:** https://neetcode.io/practice/practice/neetcode150

Use the official page for the authoritative problem order, current difficulty, and direct LeetCode links. The list can evolve, so this plan intentionally does not duplicate a potentially stale third-party copy of every problem URL.

---

# Final Target

By the end of these 8 weeks:

> **150 NeetCode problems attempted + systematic re-solves + 8 mocks + unseen Medium practice + Java fluency + interviewer-style communication.**

The finish line is not the checkbox `150/150`.

The finish line is being given an unfamiliar coding problem in a real interview and calmly saying:

> "Let me clarify the constraints first. I see a brute-force approach, but the bottleneck is ____. The key observation is ____. I can solve this using ____ while maintaining ____."

Then writing the correct Java solution and defending it.
