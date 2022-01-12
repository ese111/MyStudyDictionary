# Queue
## Queue란?
선입선출(FIFO)의 방식을 가진 자료구조로 먼저 들어간 데이터가 먼저 나온다

## 구현 사항
- add()
    - 추가하는 함수 
    ```kotlin
    fun add(data: T) {
        var item = Node<T>(data)
        if(last != null){
            last!!.next = item
        }
        last = item
        if(first == null){
            first = last
        }
    }
    ```

- remove()
    - 첫번째 데이터를 반환과 삭제하는 함수
    ```kotlin
    fun remove(): T? {
        if(first == null){
            throw NoSuchElementException("Nothing!")
        }
        val data: T = first!!.data
        first = first?.next
        if(first==null){
            last = null
        }
        return data
    }
    ```
- isEmpty()
    - Queue가 비어있는지 확인하는 함수
    ```kotlin
    fun isEmpty(): Boolean = if(first == null) true else false
    ```
- peek()
    - 첫번째 데이터를 반환하는 함수
    ```kotlin
    un peek(): T? {
        if(first == null){
            throw NoSuchElementException("Nothing!")
        }
        return first!!.data
    }
    ```
### 테스트
[테스트 결과](./img/queue.png)