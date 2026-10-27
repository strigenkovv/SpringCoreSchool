# Контекст проекта

## Проекты

- Проект для заданий: `D:/opleding/IdeaProjects/school`
- Материалы курса: `D:/opleding/Spring/SpringCoreMateriaal`
- Проект для обучения не смешивать с проектом `school`.

## Выполненные задания

- 1.2: созданы feature-пакеты `leerlingen` и `lessen`.
- 1.3: создан immutable domain class `Leerling`.
- 1.4: создан bean `LeerlingRepository`.
- 1.5: создан `MyRunner` с `CommandLineRunner`.
- 1.6: `LeerlingRepository.findAll()` читает `leerlingen.csv`.
- 1.7: `LeerlingRepository` внедрён в `MyRunner`.
- 1.8: добавлены `Les` и `LesRepository`, уроки выводятся в `MyRunner`.
- 1.9: добавлены реализации `CsvLeerlingRepository` и `PropertiesLeerlingRepository`.

## Текущая настройка dependency injection

- `LeerlingRepository` — интерфейс.
- `CsvLeerlingRepository` помечен `@Qualifier("CSV")`.
- `PropertiesLeerlingRepository` помечен `@Qualifier("PROPERTIES")`.
- В `MyRunner` используется `@Qualifier("PROPERTIES")`.
- Ученики читаются из `D:/opleding/Spring/SpringCoreMateriaal/leerlingen.properties`.
- Уроки читаются из `D:/opleding/Spring/SpringCoreMateriaal/lessen.csv`.

## Git

- Remote проекта: `https://github.com/strigenkovv/SpringCoreSchool.git`
- Сообщения commit пишем на нидерландском.
