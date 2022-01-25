# Process, Thread
## 프로세스
- cpu가 처리하는 작업
- 실행중인 프로그램
- 스토리지의 프로그램이 메모리에 적재되어 운영체제가 관리하는 상태

### 프로세스 상태
- New: 프로그램이 메인 메모리에 할당
- Ready: 할당된 프로그램이 초기화를 통해 준비
- Running: CPU가 프로세스 실행
- Waitng: 프로세스가 끝나지 않은 시점에서 I/O로 인해 CPU를 안쓰고 다른 작업
- Terminated: 종료

### PCB(Process Control Block)
- 프로세스의 대한 정보가 있는곳
- TCB(Task Control Block)이라고도 함
- 프로세스의 상태, 프로세스 번호(PID), 해당 프로세스의 program counter(pc), register값, MMU정보, CPU점유 시간 등이 포함
- PCB는 운영체제 내부의 프로세스를 관리하는 코드 부분에 저장
CPU는 프로세스를 바꿔가며 수행하기 떄문에 수행했던 프로세스에 대한 정보가 있어야 다시 수행할때 이어서 작업이 가능하다. 그걸 저장하는 곳이 PCB이다.

### 프로세스 큐
프로세스의 상태가 변할때마다 서비스를 받는 곳이 달라지고 순서대로 대기하는 곳이 큐이다.
#### 종류
- Job Queue: 하드디스크에 있는 프로그램이 실행되기 위해 메인 메모리의 할당 순서를 기다리는 큐
- Ready Queue: CPU 점유 순서를 기다리는 큐
- Device Queue: I/O를 하기 위한 여러 장치가 있는데, 각 장치를 기다리는 큐가 각각 존재

#### 스케쥴링
- 큐 내부에 저장된 데이터는 각 프로세스의 PCB가 저장
- 순서를 정해주는 알고리즘이 있어야 한다. 이러한 알고리즘을 스케줄링(Scheduling)이라 한다.

    - Job Queue - Job Scheduler(Long-term scheduler)
        - job scheduler를 long-term scheduler라고도 하는데, 이는 이 스케줄링이 발생하는 시간이 비교적 오래걸리기 때문
    - Ready Queue - CPU Scheduler(Short-term scheduler)
        - short-term scheduler라고도 하는데, 이는 스케줄링이 발생하는 시간이 매우 짧기 때문
        - 프로세스가 CPU를 점유하는 순서를 정해주는데 이는 매우 빠른 시간안에 이루어져야한다. 현대 컴퓨터가 여러 프로그램을 동시에 사용하는 것과 같은 효과를 주는 이유가 이 스케줄링 속도가 매우 빠르게 이루어지기 때문
    - Device Queue - Device Scheduler


