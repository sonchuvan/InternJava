package demo_jdbc.servive;

interface DBService<T> {
   void saveBusRouteToDB(T t);
}
