# Data Schema — Seats Reservation System

> The diagram shows all database tables, their fields, and the relationships between them.
> The grey blocks on the right are lists of allowed values (Enum).

```mermaid
erDiagram

    %% ─── TABLES ────────────────────────────────────────────────

    cinemas {
        Long   id      PK "Identifier"
        String name       "Cinema name"
        String address    "Address"
        String city       "City"
    }

    halls {
        Long   id         PK "Identifier"
        Long   cinema_id  FK "Cinema"
        String name          "Hall name"
    }

    movies {
        Long    id               PK "Identifier"
        String  title               "Movie title"
        Integer duration_minutes    "Duration (min)"
        String  age_rating          "Age rating"
        Float   rating              "Rating"
        String  poster_url          "Poster URL"
        String  description         "Description"
        Integer release_year        "Release year"
    }

    movie_genres {
        Long   movie_id  FK "Movie"
        String genre        "Genre"
    }

    sessions {
        Long      id         PK "Identifier"
        Long      movie_id   FK "Movie"
        Long      hall_id    FK "Hall"
        String    title         "Session title"
        LocalDate date          "Date"
        LocalTime time          "Time"
        String    language      "Language"
        String    format        "Format"
    }

    price_category {
        Long   id     PK "Identifier"
        String type      "Category type"
        String name      "Name"
        Float  price     "Price"
    }

    seats {
        Long    id                 PK "Identifier"
        Long    hall_id            FK "Hall"
        Long    price_category_id  FK "Price category"
        Integer row                   "Row"
        Integer number                "Seat number"
        String  status                "Status"
        Boolean is_available          "Available?"
        String  comment               "Comment"
    }

    session_seats {
        Long   id            PK "Identifier"
        Long   session_id    FK "Session"
        Long   seat_id       FK "Seat"
        String status           "Status"
        String is_available     "Available?"
        String customer_name    "Customer name"
        String contact          "Contact"
    }

    %% ─── RELATIONSHIPS ──────────────────────────────────────────

    cinemas         ||--o{ halls         : "has"
    halls           ||--o{ seats         : "contains"
    halls           ||--o{ sessions      : "hosts"
    movies          ||--o{ sessions      : "shown in"
    movies          ||--o{ movie_genres  : "has genres"
    price_category  ||--o{ seats         : "prices"
    sessions        ||--o{ session_seats : "contains"
    seats           ||--o{ session_seats : "booked in"
```

---

## Allowed Values (Enum)

| Enum | Values |
|------|--------|
| **AgeRating** (age rating) | `G` — all audiences · `PG` — parental guidance · `PG_13` — 13 and older · `R` — 17 and older · `NC_17` — adults only |
| **Genre** (movie genre) | `ACTION` · `ADVENTURE` · `ANIMATION` · `COMEDY` · `DOCUMENTARY` · `DRAMA` · `FANTASY` · `HORROR` · `SCI_FI` · `ROMANCE` · `THRILLER` |
| **MovieLang** (session language) | `ENGLISH` · `RUSSIAN` · `UZBEK` |
| **MovieFormat** (screening format) | `TWO_D` (2D) · `THREE_D` (3D) · `IMAX` |
| **PriceCategory** (price tier) | `LUXURY` · `REGULAR` · `ECONOMY` |
| **SeatStatus** (seat status) | `ACTIVE` · `DEACTIVATED` |

---

## How to Read the Diagram

- **Rectangle** = a database table (one row = one record)
- **PK** = primary key (unique identifier of a row)
- **FK** = foreign key (a reference to another table)
- Line **`||--o{`** = one-to-many: one cinema → many halls, one movie → many sessions, etc.
