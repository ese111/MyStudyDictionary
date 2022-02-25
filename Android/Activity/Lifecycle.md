# Activity Lifecycle

- Lifecycle은 무엇인가?
	- Activity는 main함수로 실해되는 다른 함수들과 다르게 onCreate(), onStart(), onResume(), onPause(), onStop(), onDestroy()로 이루어진 Lifecycle의 콜백으로 실행과 종료가 결정되고 사용자가 다른 활동을 할때 등 어떤 상태로 있어야 되는지를 결정한다. Activity는 Lifecycle로 인해서 만들어지고 쉬고 사라진다. 
	- onCreate(): Activity의 생성을 의미한다 Activity가 시작되기전에 onCreate()을 통해서 생성이 이루어져야 실행이 가능한 상태가 된다. 뷰를 구성하고 결합하는 과정을 하고 onStart()를 콜백한다
	- onStart(): onCreate()이 종료되면 Activity를 시작하고 사용자에게 표기한다. Forground에서 대화형이 되기위한 최종 준비를 한다.
	- onResume(): Activity가 사용자와 상호작용을 하기전 콜백된다. Activity를 Stack의 맨 위에 있을때 실행되고 핵심 기능들이 여기에서 구현된다.
	- onPause(): Activity가 포커스를 잃고 일시중지 될때 호출되는 콜백이다. 예를 들어 뒤로 가기를 하거나 최근 활동을 누르면 작동한다. 앱이 일부는 보이지만 사용자가 정지를 할거나 앱이 restart할 거 같을때를 나타낸다. 미디어 플레이어나 네이게이션을 사용 할 때처럼 사용자가 UI업데이트를 기다리고 있을때 pause된 Activity는 포커스를 잃어도 계속해서 UI를 업데이트 할 수 있다. 트랙젝션같은 부하 큰 작업을 하기에는 onPause()는 너무 짧기 때문에 여기서 실행하면 안된다. 예를 들어 사용자가 뒤로가기를 눌러 Activity가 소멸할 경우 트랙잭션이 작동하지 않을 수 있다. onPause()가 완료되면 상황에 따라 onStop()이나 onResume()을 실행한다.
	- onStop(): Activity가 사용자에게 더 이상 표시 되지 않을때 호출된다. Activity를 제거 중이거나 새 Activity가 시작 중이거나 기존 활동이 Restart로 전환 중일때 발생한다. 중지된 Activity는 더 이상 표시되지 않는다.
	Activity가 다시 실행되면 onRestart()를 콜백하고 종료면 onDestroy()를 콜백한다.
	- onRestart(): onStop() 이후 Activity가 다시 실행될때 호출된다. Activity 상태를 복원한다. 뒤에는 항상 onStart()가 온다.
	- onDestroy(): Activity가 완전히 제거되기 전에 이 콜백을 호출한다. Activity가 수신하는 마지막 콜백이다. Activity 또는 연관된 프로세스를 제거하고 모든 리소스를 해제한다.

- Lifecycle이 변경되었음은 어떻게 알 수 있는가?
	- Activity 클래스에서는 위에 적힌 라이프 사이클 콜백들을 지원한다. 사용자가 뒤로가기를 누르거나 앱을 실행하는 등 여러 활동을 하면 액티비티는 각 콜백들을 호출해서 현재 어떤 라이프사이클 상태인지 알려주고 상태가 변화 할때 마다 다른 콜백을 호출해서 현재 상태를 알립니다.