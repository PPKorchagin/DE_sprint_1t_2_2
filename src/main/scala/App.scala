import jdk.nashorn.internal.runtime.options.KeyValueOption

import Ordering.Implicits._


object App extends App {

  def task2 (str: String) {
     println(str)
  }

  def task3_a_1(str: String): Unit ={
    println(str.reverse)
  }

  def task3_a_2(str: String): Unit ={
    println(str.toLowerCase)
  }

  def task3_a_3(str: String, simvol: String): Unit ={
    println(str.replace(simvol, ""))
  }

  def task3_a_4(str: String, endStr: String): Unit ={
    println(str + endStr)
  }

  def task3_b (income: Double, prize: Double, paybackForFood: Double): Double = {
    val withoutFood = income - paybackForFood
    val withBonus = withoutFood / (1 + prize / 100)
    val incomeMonth = (withBonus/12) * 0.87
    incomeMonth
  }

  def avgIncome (incomeList: List[Float]): Float ={
    //get avg income
    val avgIncome =  incomeList.sum / incomeList.length
    avgIncome
  }

  def task3_с(incomeList: List[Float]) = {
    val incomeAvg  = avgIncome(incomeList)
    incomeList.zipWithIndex.foreach { case (v, i) => {
      println("Для дохода " + i.toString + " (" + v.toString + ") отклонение " + (v - incomeAvg).toString)
    }
    }
  }

  def task3_d(incomeList: List[Float], numPos: Int, valUpdate: Float):Float = {
    val newIncome =  incomeList(numPos) + valUpdate
    newIncome
  }
  def get_idx(incomeList: List[Float], newIncome: Int) :Int={
    var i:Int=0
    for (i <- 0 to (incomeList.length - 1)) {
      if (incomeList(i) > newIncome) {
        return i
      }
    }
    return incomeList.length
  }

  def insert[T](list: List[T], i: Int, value: T) =
    list.take(i) ++ List(value) ++ list.drop(i)

  println("Задание 2")
  task2("Hello, Scala!")

  println("Задание 3 a 1")
  task3_a_1("Hello, Scala!")

  println("Задание 3 a 2")
  task3_a_2("Hello, Scala!")

  println("Задание 3 a 3")
  task3_a_3("Hello, Scala!", ",")

  println("Задание 3 a 4")
  task3_a_4("Hello, Scala!", " and goodbye python!")

  println("Задание 3 b")
  println("Ежемесяцный оклад сотрудника: " +  task3_b(1000000,0.2, 10000))

  println("Задание 3 c")
  val incomeList = List[Float](100, 150, 200, 80, 120, 75)
  task3_с(incomeList)

  println("Задание 3 d")

  //выбираем по id
  val numPos = 1
  //Теперь пишем сумму на которую меняем ему оклад
  val valUpdate = -50

  println("Обновленный оклад " + task3_d(incomeList, numPos, valUpdate).toString)

  val IncomeList = task3_d(incomeList, numPos, valUpdate) +: incomeList
  println("Максимальная зарплата " + IncomeList.max)
  println("Минимальная зарплата " + IncomeList.min)

  println("Задание 3 e")
  val newEmployee1 = 350.0.toFloat
  val newEmployee2 = 90.0.toFloat
  val newIncomeList = newEmployee1 +: newEmployee2 +: IncomeList
  println("Отсортированные список зарплат " + newIncomeList.sorted)

  println("Задание 3 f")

  val addNewIncome = 130
  val idx = get_idx(newIncomeList.sorted, addNewIncome)
  val allIncomeList = insert(newIncomeList.sorted, idx, addNewIncome)
  println("Финальный лист зарплат ", allIncomeList)
}
