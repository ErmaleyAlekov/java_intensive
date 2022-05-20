Программа считывает в качестве аргументов два символа, на которые нужно заменить белый и черный цвет изображения.
Результат выводится в стандартный output(консоль).
Команда для компиляции при условие что вы находитесь в папке проекта всего дня.
javac -d ex01/ImagesToChar/target ./ex01/ImagesToChar/src/java/edu_school21_printer/app/* ./ex00/ImagesToChar/src/java/edu_school21_printer/logic/*
Запускать программу нужно из директории ex01/ImagesToChar/target
java -jar images-to-chars-printer.jar 0 -
или
java edu_school21_printer.app.Logic + путь до картинки
Собрать архив из директории ex01/ImagesToChar/target
jar -cvfm images-to-chars-printer.jar ../src/manifest.txt ./edu_school21_printer/app/Program.class ./edu_school21_printer/logic/Logic.class