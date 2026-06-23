# LeetCode — що це і як вирішувати задачі

## Що таке LeetCode і навіщо він потрібен

LeetCode — це платформа з алгоритмічними задачами. Їх вирішують на технічних інтерв'ю в Google, Meta, Amazon, Spotify та інших компаніях. Суть не в тому щоб вивчити відповіді — а в тому щоб навчитись **розпізнавати паттерни** і знати яку структуру даних застосувати.

---

## Big O — складність алгоритму

Перед усім треба зрозуміти Big O. Це спосіб описати наскільки швидко росте час виконання або використання пам'яті при збільшенні вхідних даних.

```
O(1)        — константа, не залежить від розміру (читання з масиву за індексом)
O(log n)    — логарифм (бінарний пошук)
O(n)        — лінійний (один прохід по масиву)
O(n log n)  — сортування (merge sort, heap sort)
O(n²)       — квадратичний (вкладені цикли)
O(2ⁿ)       — експоненціальний (всі підмножини)
```

**Правило**: якщо n = 10⁵, то O(n²) = 10¹⁰ операцій — це занадто повільно. Прагни до O(n) або O(n log n).

---

## Структури даних

### Array (масив)
Найбазовіша структура. Елементи в пам'яті йдуть підряд.

```kotlin
val arr = intArrayOf(1, 2, 3, 4, 5)
arr[0]       // читання — O(1)
arr[2] = 10  // запис — O(1)
```

**Коли використовувати**: індексований доступ, sliding window, two pointers.

---

### HashMap / HashSet
HashMap зберігає пари ключ → значення. HashSet зберігає унікальні елементи.
Пошук, вставка, видалення — O(1) в середньому.

```kotlin
val map = mutableMapOf<Int, Int>()
map[5] = 10          // зберегти
map[5]               // отримати — 10
map.containsKey(5)   // перевірити — true

val set = mutableSetOf<Int>()
set.add(3)
set.contains(3)      // true
```

**Коли використовувати**: коли треба швидко перевірити "чи бачили ми це вже" або "скільки разів зустрічалось".

**Приклад задачі — Two Sum:**
> Дано масив nums і число target. Знайди два індекси, сума яких = target.
```kotlin
fun twoSum(nums: IntArray, target: Int): IntArray {
    val seen = mutableMapOf<Int, Int>() // значення -> індекс
    for ((i, num) in nums.withIndex()) {
        val complement = target - num
        if (complement in seen) {
            return intArrayOf(seen[complement]!, i)
        }
        seen[num] = i
    }
    return intArrayOf()
}
```

---

### Stack (стек)
Працює за принципом LIFO — Last In, First Out. Як стопка тарілок.

```kotlin
val stack = ArrayDeque<Int>()
stack.addLast(1)   // push
stack.addLast(2)
stack.removeLast() // pop — повертає 2
stack.last()       // peek — дивимось верхній без видалення
```

**Коли використовувати**: дужки, "наступний більший елемент", відміна дій.

**Приклад — Valid Parentheses:**
> Перевір чи всі дужки правильно закриті: `"()[]{}"` → true, `"(]"` → false
```kotlin
fun isValid(s: String): Boolean {
    val stack = ArrayDeque<Char>()
    for (c in s) {
        when (c) {
            '(', '[', '{' -> stack.addLast(c)
            ')' -> if (stack.isEmpty() || stack.removeLast() != '(') return false
            ']' -> if (stack.isEmpty() || stack.removeLast() != '[') return false
            '}' -> if (stack.isEmpty() || stack.removeLast() != '{') return false
        }
    }
    return stack.isEmpty()
}
```

---

### Queue (черга)
Працює за принципом FIFO — First In, First Out. Як черга в магазині.

```kotlin
val queue = ArrayDeque<Int>()
queue.addLast(1)    // enqueue
queue.addLast(2)
queue.removeFirst() // dequeue — повертає 1
```

**Коли використовувати**: BFS (обхід в ширину), обробка по черзі.

---

### Linked List (зв'язний список)
Кожен вузол містить значення і посилання на наступний вузол.

```kotlin
class ListNode(var `val`: Int, var next: ListNode? = null)
```

**Коли використовувати**: реверс списку, знайти середину, cycle detection.

**Класичний трюк — Fast & Slow Pointers:**
```kotlin
// Знайти середину списку
fun middleNode(head: ListNode?): ListNode? {
    var slow = head
    var fast = head
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }
    return slow // slow зупинився на середині
}
```

---

### Tree (дерево) та Binary Search Tree

```kotlin
class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)
```

**DFS — обхід в глибину** (рекурсія):
```kotlin
fun inorder(root: TreeNode?): List<Int> {
    if (root == null) return emptyList()
    return inorder(root.left) + root.`val` + inorder(root.right)
}
```

**BFS — обхід в ширину** (черга, рівень за рівнем):
```kotlin
fun levelOrder(root: TreeNode?): List<List<Int>> {
    if (root == null) return emptyList()
    val result = mutableListOf<List<Int>>()
    val queue = ArrayDeque<TreeNode>()
    queue.addLast(root)
    while (queue.isNotEmpty()) {
        val level = mutableListOf<Int>()
        repeat(queue.size) {
            val node = queue.removeFirst()
            level.add(node.`val`)
            node.left?.let { queue.addLast(it) }
            node.right?.let { queue.addLast(it) }
        }
        result.add(level)
    }
    return result
}
```

---

### Heap / PriorityQueue
Завжди тримає мінімальний (або максимальний) елемент зверху. Вставка і видалення — O(log n).

```kotlin
val minHeap = PriorityQueue<Int>()         // мін зверху
val maxHeap = PriorityQueue<Int>(reverseOrder()) // макс зверху

minHeap.add(5)
minHeap.add(1)
minHeap.add(3)
minHeap.poll() // 1 — завжди повертає мінімум
```

**Коли використовувати**: "знайди K найбільших/найменших елементів".

---

## Паттерни вирішення задач

### 1. Two Pointers
Два вказівники рухаються по масиву — один з початку, один з кінця (або обидва з початку).

**Коли**: відсортований масив, пари, palindrome.

```kotlin
// Чи є рядок паліндромом?
fun isPalindrome(s: String): Boolean {
    var left = 0
    var right = s.length - 1
    while (left < right) {
        if (s[left] != s[right]) return false
        left++
        right--
    }
    return true
}
```

---

### 2. Sliding Window
Вікно фіксованого або змінного розміру ковзає по масиву. Уникаємо вкладених циклів.

**Коли**: підрядок, підмасив, "максимум/мінімум в діапазоні".

```kotlin
// Максимальна сума підмасиву розміру k
fun maxSumSubarray(nums: IntArray, k: Int): Int {
    var windowSum = nums.take(k).sum()
    var maxSum = windowSum
    for (i in k until nums.size) {
        windowSum += nums[i] - nums[i - k] // додаємо новий, прибираємо старий
        maxSum = maxOf(maxSum, windowSum)
    }
    return maxSum
}
```

---

### 3. Binary Search
Застосовується не тільки для пошуку в масиві — але і для пошуку відповіді в діапазоні значень.

**Коли**: відсортований масив, "знайди мінімальне X при якому умова виконується".

```kotlin
fun binarySearch(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    while (left <= right) {
        val mid = left + (right - left) / 2 // так не буде overflow
        when {
            nums[mid] == target -> return mid
            nums[mid] < target -> left = mid + 1
            else -> right = mid - 1
        }
    }
    return -1
}
```

---

### 4. Dynamic Programming (DP)
Розбиваємо задачу на підзадачі і зберігаємо їх результати щоб не рахувати двічі.

**Коли**: "скільки способів", "максимальна/мінімальна вартість", "чи можливо".

**Шаблон думки**:
1. Що таке `dp[i]`? (що означає)
2. Яка базова умова? (`dp[0] = ?`)
3. Яка формула переходу? (`dp[i] = dp[i-1] + ...`)

```kotlin
// Fibonacci — класичний DP
fun fib(n: Int): Int {
    if (n <= 1) return n
    val dp = IntArray(n + 1)
    dp[0] = 0
    dp[1] = 1
    for (i in 2..n) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }
    return dp[n]
}
```

---

### 5. Backtracking
Перебираємо всі можливості, повертаємось якщо зайшли в глухий кут.

**Коли**: всі комбінації, всі перестановки, sudoku.

```kotlin
// Всі підмножини масиву
fun subsets(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    fun backtrack(start: Int, current: MutableList<Int>) {
        result.add(current.toList()) // додаємо поточний стан
        for (i in start until nums.size) {
            current.add(nums[i])
            backtrack(i + 1, current)
            current.removeLast() // відкочуємось назад
        }
    }
    backtrack(0, mutableListOf())
    return result
}
```

---

## Як підходити до задачі

```
1. Прочитай умову двічі
2. Розбери приклади вручну на папері
3. Запитай себе:
   - Масив відсортований? → Binary Search або Two Pointers
   - Підрядок / підмасив? → Sliding Window
   - Дерево / граф? → DFS або BFS
   - Максимум / мінімум / кількість способів? → DP
   - Треба перевірити "чи бачили"? → HashMap / HashSet
4. Напиши brute force рішення (навіть O(n²))
5. Подумай як оптимізувати
6. Напиши код
7. Перевір на edge cases: пустий масив, один елемент, від'ємні числа
```

---

## З чого починати

| Тиждень | Тема                        | Задачі для старту                          |
|---------|-----------------------------|--------------------------------------------|
| 1       | Array + HashMap             | Two Sum, Contains Duplicate, Valid Anagram |
| 2       | Two Pointers + Sliding Win. | Best Time to Buy Stock, Longest Substring  |
| 3       | Binary Search               | Binary Search, Search in Rotated Array     |
| 4       | Linked List                 | Reverse Linked List, Merge Two Lists       |
| 5       | Trees                       | Invert Tree, Max Depth, Same Tree          |
| 6       | Stack + Queue               | Valid Parentheses, Min Stack               |
| 7       | DP (1D)                     | Climbing Stairs, House Robber, Coin Change |

**Рекомендований список**: NeetCode 150 (neetcode.io) — структурований по паттернах.

---

## Головне правило

Не знаєш як вирішити за 20-30 хвилин — дивись рішення. Вивчай паттерн, а не відповідь.
Через день повторно виріши задачу без підказок. Саме так будується м'яз.
