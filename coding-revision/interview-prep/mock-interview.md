# 🎤 Mock Interview Protocol

> **Use this file every Saturday.** Copy the prompt below, fill in your topic, paste it into a new chat with the AI agent. The agent will run the full mock interview, drop indirect hints only, and give you a written post-mortem at the end.

---

## When to run a mock

Per `topic-wise-schedule.md`:

| Topic length | Mocks | Saturdays |
|---|---|---|
| 14-day topic (most) | 2 | Day 6 (mid), Day 13 (end) |
| 10-day topic (Tries, Intervals, Bit) | 1 | Day 6 |
| 21-day DP | 3 | Day 6, Day 13, Day 20 |

By end of program: **~46 mock interviews**.

---

## ⚡ The prompt — copy, fill in, paste into a new chat

> Hi! I want to run a **mock coding interview** with you as the interviewer.
>
> **Topic:** `<paste topic name from the schedule, e.g. "Arrays & Strings">`
> **Mock # in this topic:** `<1, 2, or 3>`
> **Mock format (auto from above):**
> - Mock #1 → 30 min, 1 Easy or 1 Medium from this topic
> - Mock #2 → 75 min total, 1 Medium (30 min) + 1 Hard (45 min)
> - Mock #3 (DP only) → 90 min, 2 Hard problems back-to-back (45 min each)
>
> ---
>
> **Rules for you (the interviewer):**
> 1. Pick problem(s) randomly from the topic file `topics/<topic-slug>.md`. **Don't tell me the problem number or the LeetCode title** — describe the problem in your own words like a real interviewer would.
> 2. Start the timer. Tell me when **25%, 50%, 75%** of time has elapsed.
> 3. I'll think out loud. You respond ONLY with **indirect hints** — never name the algorithm, data structure, or pattern. Examples of allowed hints:
>    - "What's the brute force here?"
>    - "Walk me through your first example."
>    - "What's the time complexity of that?"
>    - "Is there a data structure that makes step X faster?"
>    - "What if the input were sorted?"
>    - "Notice anything about the problem if you split it in half?"
> 4. **NEVER** say things like "use a hashmap" or "this is sliding window". Always lead me to it with questions.
> 5. If I'm silent for 5+ minutes, give a softer indirect nudge.
> 6. When I propose a solution, ask me 1–2 follow-up questions:
>    - "What's the time and space complexity?"
>    - "What edge cases might break this?"
>    - "Is there a way to do it in less space?"
> 7. If I write code, review it line by line and ask me to walk through it with one example.
>
> ---
>
> **At the end, give me a written post-mortem. Be honest, not flattering. Use these sections:**
>
> 1. **Problem identification** — Did I correctly identify the pattern? How long did it take me?
> 2. **Communication** — Did I explain my thinking clearly? Did I clarify inputs and constraints?
> 3. **Brute force first** — Did I propose one before optimizing?
> 4. **Optimization path** — Did I optimize logically? Where did I jump steps or get stuck?
> 5. **Code quality** — Naming, structure, off-by-ones, edge-case handling.
> 6. **Complexity analysis** — Did I state final time and space correctly?
> 7. **Score** — Rate me 1–10 on each axis above, then give an **overall signal**: `hire` / `lean-hire` / `lean-no-hire` / `no-hire`.
> 8. **Top 3 improvements** to focus on this week.
> 9. **3 follow-up problems** (LeetCode #s) that drill the same weakness.
>
> Begin the interview now. Start by introducing yourself briefly as the interviewer, then state the problem.

---

## My commitments during a mock (the candidate side)

- ❌ **No notes, no Google, no LeetCode editorial.** It's a real interview.
- ✅ **Talk out loud the entire time.** Silent thinking = silent failure in interviews.
- ✅ **Always restate the problem** in my own words first.
- ✅ **Always clarify** input range, constraints, return type before coding.
- ✅ **Always give a brute force** before optimizing.
- ✅ **Always state complexity** before declaring "done".
- ✅ **Test code** with at least 2 examples (one given, one edge case).
- ✅ **Code in Java** (or my interview language of choice — be consistent).

---

## After each mock — the must-do follow-up

1. **Read the post-mortem carefully.** Don't skim.
2. **Add the 3 follow-up problems** to your weekly stretch list.
3. **If overall signal was `no-hire` or `lean-no-hire`:**
   - Redo the SAME problem 48 hours later, cold (no notes).
   - Don't proceed to the next topic until you can solve a similar Medium/Hard from this topic in time.
4. **Update `topics/<topic>.md`** — mark the mock problem with `[x]` if solved cleanly, `[~]` if hinted, `[ ]` if failed.

---

## Sample interviewer style (what to expect)

| ❌ Bad (gives away pattern) | ✅ Good (interviewer style) |
|---|---|
| "This is a sliding-window problem. Use two pointers." | "Walk me through what changes between the window of size 3 starting at index 0 vs index 1. Notice anything?" |
| "You should use a HashMap." | "What operation is dominating your runtime? Is there a data structure that makes that O(1) instead of O(n)?" |
| "Use BFS." | "If you had to find the shortest sequence of moves, would you go deep or wide?" |
| "Sort the array first." | "Does the order of input matter for your algorithm? What happens if you change it?" |
| "Use DP." | "You're solving the same sub-problem twice — what could you do about that?" |

---

## What a "good" mock looks like (target state)

After 5–10 mocks across topics, you should be hitting these benchmarks:

| Metric | Target |
|---|---|
| Time to identify pattern | < 5 min |
| Brute force proposed | Always, before any optimization |
| Communication score | ≥ 7/10 |
| Code complexity stated | Always, unprompted |
| Edge cases caught | ≥ 2 per problem |
| Overall signal | `lean-hire` or `hire` on ≥ 60% of mocks |

---

## Quick command — to log mocks you've done

Append a line per mock to your own `mock-log.md` (create when you start). Template:

```
| Date | Topic | Mock # | Problem(s) | Signal | Top weakness |
|------|-------|--------|------------|--------|--------------|
| 2026-06-27 | Arrays & Strings | 1 | LC #11 | lean-hire | Off-by-one in two-pointer loop |
```

This becomes priceless 3 months in — you'll see your patterns of weakness emerge.

---

**Saturday is interview day. Show up like it's the real thing.**

