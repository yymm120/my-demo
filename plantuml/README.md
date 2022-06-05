
```puml

/' 1. 元素 '/
@startuml
'https://plantuml.com/class-diagram

/'元素声明'/
abstract        抽象
abstract class  抽象(等同abstract)
annotation      注解
circle          圆
()              圆缩写形式
class           类
diamond         菱形
<>              菱形写形式
entity          实例
enum            枚举
interface       接口
@enduml
```
```puml
/' 2. 关系  '/
@startuml
/'
扩展  <|--
组成  *__
聚合  0--
'/
Class01 <|-- Class02
Class03 *-- Class04
Class05 o-- Class06
Class07 .. Class08
Class09 -- Class10
@enduml
```
```puml
/' --> 垂直箭头'/
/' -> 水平箭头'/
/' -left-> 自定义方向箭头'/
@startuml
left to right direction
Class11 <|.. Class12
Class13 --> Class14
Class15 ..> Class16
Class17 ..|> Class18
Class19 <--* Class20
@enduml
```
```puml

@startuml
Class21 #-- Class22
Class23 x-- Class24
Class25 }-- Class26
Class27 +-- Class28
Class29 ^-- Class30
@enduml
```
```puml
/' 3. 关系上的标签 '/
@startuml
/'
:   为关系添加注释
""  为元素添加注释
>   指明作用关系
'/

类01 "1" *-- "many" 类02 : 包含

类03 o-- 类04 : 聚合

类05 --> "1" 类06

@enduml
```
```puml

@startuml
class 汽车

发动机 - 汽车 : 驱动 >
汽车 *- 轮子 : 拥有 4 >
汽车 -- 人 : < 所属

@enduml
```
```puml

/' 4. 属性和方法 '/
@startuml
/'
-   private
#   protect
~   package
+   public
'/
class Dummy {
  -String data
  +void methods()
}

class Flight {
   #flightNumber : Integer
   ~departureTime : Date
}

class Dummy {
  +{field} A field (despite parentheses)
  -{method} Some method
}

@enduml
```
```puml
@startuml
/'
{static}    静态属性
{abstract}  抽象方法
'/
class Dummy {
  {static} String id
  {abstract} void methods()
}
@enduml
```
```puml

/' 5. 高级类体'/
@startuml
/'
.. | == | -- 都可以作为分隔符，也可以加上标题
'/
class Foo1 {
  You can use
  ..
  and group
  ==
  End of class
}
class User {
  .. Simple Getter ..
  + getAddress()
  .. Some setter ..
  + setName()
  __ private data __
  int age
  -- encrypted --
  String password
}
@enduml
```
```puml
/' 6. 备注和模板 '/
@startuml
/'
<< 模板 >>
note top of Object:
note bottom of Object:
note as Name1
note as Name2 .. Object .. Name2
或者在类的末尾直接声明note left:
'/
class Object << general >>
Object <|--- ArrayList

note top of Object : In java, every class\nextends this one.

note "This is a floating note" as N1
note "This note is connected\nto several objects." as N2
Object .. N2
N2 .. ArrayList

class Foo
note left: On last defined class

@enduml
```
```puml


/' 可以在注释种使用html '/
@startuml

class Foo
note left: On last defined class

note top of Object
  In java, <size:18>every</size> <u>class</u>
  <b>extends</b>
  <i>this</i> one.
end note

note as N1
  This note is <u>also</u>
  <b><color:royalBlue>on several</color>
  <s>words</s> lines
  And this is hosted by <img:sourceforge.jpg>
end note

@enduml
```
```puml
/' 可以对某个属性进行注释 '/
@startuml
/'
note left of 类名::属性(类型)
    content
end note
'/
class A {
{static} int counter
+void {abstract} start(int timeout)
}
note left of A::counter
  该成员已注释
end note
note right of A::start
  在 UML 注释了此方法
end note
@enduml

```
```puml
/' 可以给线条添加注释'/
@startuml

class Dummy
Dummy --> Foo : A link
note on link #red: note that is red

Dummy --> Foo2 : Another link
note right on link #blue
this is my note on right link
and in blue
end note

@enduml
```
```puml
/' 使用非字母符号'/
@startuml
class "This is my class" as class1
class class2 as "It works this way too"

class2 *-- "foo/dummy" : use
@enduml
```
```puml


/' hide/show 隐藏属性'/
@startuml

class Dummy1 {
  +myMethods()
}

class Dummy2 {
  +hiddenMethod()
}

class Dummy3 <<Serializable>> {
String name
}

hide members
hide <<Serializable>> circle
show Dummy1 methods
show <<Serializable>> fields

@enduml
```
```puml

/' 隐藏类'/
@startuml

class Foo1
class Foo2

Foo2 *-- Foo1

hide Foo2

@enduml
```
```puml
/' 隐藏未关联的类'/
@startuml
class C1
class C2
class C3
C1 -- C2

hide @unlinked
@enduml
```

```puml

/' 泛型 '/
@startuml

class Foo<? extends Element> {
  int size()
}
Foo *- Element

@enduml
```
```puml

/' 指定标记'/
@startuml
/'在定义原型时，自定义一个颜色'/
class System << (S,#FF7700) Singleton >>
class Date << (D,orchid) >>
@enduml
```
```puml

/' 自定义命名空间，方便使用全限定名类'/
@startuml
set namespaceSeparator ???

package "Classic Collections" #DDDDDD {
  Object <|-- ArrayList
}

package net.sourceforge.plantuml {
  Object <|-- com.demomybatis.Demo1
  com.demomybatis.Demo1 *- com.demomybatis.Demo2
}

@enduml
```
```puml
/' 包之间的连线 '/
@startuml

skinparam packageStyle rectangle

package foo1.foo2 {
}

package foo1.foo2.foo3 {
  class Object
}

foo1.foo2 +-- foo1.foo2.foo3

@enduml
```
```puml
/' 不同场景可选用不同的包样式 '/
@startuml
scale 750 width
package foo1 <<Node>> {
  class Class1
}

package foo2 <<Rectangle>> {
  class Class2
}

package foo3 <<Folder>> {
  class Class3
}

package foo4 <<Frame>> {
  class Class4
}

package foo5 <<Cloud>> {
  class Class5
}

package foo6 <<Database>> {
  class Class6
}

@enduml
```
```puml
/' 定义关系类 '/
@startuml
class Student {
  Name
}
Student "0..*" - "1..*" Course

class Enrollment {
  drop()
  cancel()
}

(Student, Course) .. Enrollment
@enduml

```
```puml

/' 同级关联 '/
@startuml
class 站台 {
    +名称: 字符串
}

class 通道 {
    +花费: 剩余时间
}

<> 结点

通道 . 结点
结点 - "从 0..*" 站台
结点 - "到 0..* " 站台
@enduml

```
```puml
/' 样式修改 '/
@startuml

skinparam class {
BackgroundColor PaleGreen
ArrowColor SeaGreen
BorderColor SpringGreen
}
skinparam stereotypeCBackgroundColor YellowGreen

类01 "1" *-- "many" 类02 : 包含

类03 o-- 类04 : 聚合

@enduml
```
```puml

@startuml

skinparam class {
BackgroundColor PaleGreen
ArrowColor SeaGreen
BorderColor SpringGreen
BackgroundColor<<Foo>> Wheat
BorderColor<<Foo>> Tomato
}
skinparam stereotypeCBackgroundColor YellowGreen
skinparam stereotypeCBackgroundColor<< Foo >> DimGray

类1 <<Foo>>
类3 <<Foo>>
类1 "1" *-- "*" 类2 : 包含(contains)

类3 o-- 类4 : 聚合(aggregation)

@enduml
```
```puml


@startuml

skinparam backgroundcolor AntiqueWhite/Gold
skinparam classBackgroundColor Wheat|CornflowerBlue

class 类1 #red-green
note left of 类1 #blue\9932CC
  这是foo类的
  渐变颜色
end note

package 包1 #GreenYellow/LightGoldenRodYellow {
  class 类2
}

@enduml
```
```puml

/' 布局 '/
@startuml

class Bar1
class Bar2
together {
  class Together1
  class Together2
  class Together3
}
Together1 - Together2
Together2 - Together3
Together2 -[hidden]--> Bar1
Bar1 -[hidden]> Bar2
@enduml
```
```puml

@startuml
' Split into 4 pages
page 2x2
skinparam pageMargin 10
skinparam pageExternalColor gray
skinparam pageBorderColor black

class BaseClass

namespace net.dummy #DDDDDD {
    .BaseClass <|-- Person
    Meeting o-- Person

    .BaseClass <|- Meeting

}

namespace net.foo {
  net.dummy.Person  <|- Person
  .BaseClass <|-- Person

  net.dummy.Meeting o-- Person
}

BaseClass <|-- net.unused.Person
@enduml
```
```puml


/' 继承和实现'/
@startuml
class ArrayList implements List
class ArrayList extends AbstractList
@enduml
```
```puml

/' 线条样式 '/
@startuml
left to right direction
title 使用方括号([])表示的线样式（无标签版）

class foo类
class bar类
bar类1 : [bold]
bar类2 : [dashed]
bar类3 : [dotted]
bar类4 : [hidden]
bar类5 : [plain]

foo类 --> bar类: 标签
foo类 -[bold]-> bar类1
foo类 -[dashed]-> bar类2
foo类 -[dotted]-> bar类3
foo类 -[hidden]-> bar类4
foo类 -[plain]-> bar类5
@enduml
```
```puml


@startuml
title 使用方括号([])表示的线颜色
class foo类
class bar类
class bar类1
class bar类2
class bar类3

foo类 --> bar类            : [默认]
foo类 -[#red]-> bar类1     : [红]
foo类 -[#green]-> bar类2   : [绿]
foo类 -[#blue]-> bar类3    : [#蓝]
'foo类 -[#blue;#yellow;#green]-> bar类4
@enduml
```
```puml

@startuml
title 使用方括号([])表示的线宽度
class foo类
class bar类
bar类1 : [thickness=1]
bar类2 : [thickness=2]
bar类3 : [thickness=4]
bar类4 : [thickness=8]
bar类5 : [thickness=16]

foo类 --> bar类                 : ∅
foo类 -[thickness=1]-> bar类1   : [1]
foo类 -[thickness=2]-> bar类2   : [2]
foo类 -[thickness=4]-> bar类3   : [4]
foo类 -[thickness=8]-> bar类4   : [8]
foo类 -[thickness=16]-> bar类5  : [16]

@enduml
```
```puml

@startuml
title 使用方括号([])表示的线混合样式
class foo类
class bar类
bar类1 : [#red,thickness=1]
bar类2 : [#red,dashed,thickness=2]
bar类3 : [#green,dashed,thickness=4]
bar类4 : [#blue,dotted,thickness=8]
bar类5 : [#blue,plain,thickness=16]

foo类 --> bar类                             : ∅
foo类 -[#red,thickness=1]-> bar类1          : [#red,1]
foo类 -[#red,dashed,thickness=2]-> bar类2   : [#red,dashed,2]
foo类 -[#green,dashed,thickness=4]-> bar类3 : [#green,dashed,4]
foo类 -[#blue,dotted,thickness=8]-> bar类4  : [blue,dotted,8]
foo类 -[#blue,plain,thickness=16]-> bar类5  : [blue,plain,16]
@enduml
```
```puml

@startuml
class foo类
foo类 --> bar类 : 默认
foo类 --> bar类1 #line:red;line.bold;text:red  : 红色粗线
foo类 --> bar类2 #green;line.dashed;text:green : 绿色断线
foo类 --> bar类3 #blue;line.dotted;text:blue   : 蓝色点线
@enduml
```
```puml


@startuml
abstract   抽象类
annotation 注解     #pink ##[bold]red
class      类      #palegreen ##[dashed]green
interface  接口    #aliceblue ##[dotted]blue
@enduml
```
```puml


@startuml
class Foo类 {
+ 字段1
+ 字段2
}

class Bar类 {
+ 字段3
+ 字段4
}

Foo类::字段1 --> Bar类::字段3 : foo
Foo类::字段2 --> Bar类::字段4 : bar
@enduml
```




```puml
@startmindmap
caption figure 1
title My super title

* <&flag>Debian
** <&globe>Ubuntu
*** Linux Mint
*** Kubuntu
*** Lubuntu
*** KDE Neon
** <&graph>LMDE
** <&pulse>SolydXK
** <&people>SteamOS
** <&star>Raspbian with a very long name
*** <s>Raspmbc</s> => OSMC
*** <s>Raspyfi</s> => Volumio

header
My super header
endheader

center footer My super footer

legend right
  Short
  legend
endlegend
@endmindmap

```
```puml
@startmindmap
Title sss
* class Template
**:
<code>
import pandas
</code>
;
**: ss
# 111
### sd
;


@endmindmap

```