SPRING MVC

web browser --> front controller --(model)--> controller --(model)--> view template

Olay front controller a gelen requestle başlar.<br>
Front controller DispatcherServlet olarak da bilinir.<br>
Spring Framework un bir parçasıdır. <br>
Bu front controller request i alır sistemdeki diğer objelere/nesnelere devreder. <br>

biz developer olarak model view controller oluştururuz. burada model front controller dan view template e aktardığımızdır.
controller da business logic vardır ve model içerisindeki veriyi kullanır/işler
view template ise view kısmıdır ki burada html/jsp/thymeleaf vs UI template kısmıdır.


### Controller
developer tarafından yazılan business logic içeren kısımıdr.
<br> request i handle eder.
<br> veri saklama aktarma (db, web service)
<br> modele veriyi yerleştirme (place data in model)
<br> ilgili view template e veriyi aktarma

### Model

Verilerimizi içeren yapıdır.
Verileri model içerinde alırız ve saklarız (veriyi db den veya backend servisinden vs. alabilrz)
O çektiğimiz veriyi alır ve modele yerleştiririz.<br>
Daha sonra o veriyi spring app içerisinde modele yerleşmiş haliyle kullanırız.
Model datası, view template e aktarılabilir, view template ise o verinin display edilmesinde kullanılır
#### View Template
Datayı display etmemize olanak sağlar <br>
En yaygınları : JSP+JSTL, Thymeleaf vs <br>

