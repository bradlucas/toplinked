# toplinked

[![Clojars Project](https://img.shields.io/clojars/v/com.bradlucas/toplinked.svg)](https://clojars.org/com.bradlucas/toplinked)

A small example using linkedin-connections to find the emails in the latest toplinked email list that are not currently in a LinkedIn connections export.

### Build

    $ lein uberjar

## Usage

First download your LinkedIn connections by exporting them to either of the Outlook formats or the Yahoo format. The export connections feature is available on LinkedIn at http://www.linkedin.com/addressBookExport.

Then download the latet toplinked email list. This is currently in four files so merge them as follow.

    $ cat openLinkedIn-C8D6FEADDF661722-1of4.csv openLinkedIn-C8D6FEADDF661722-2of4.csv \
        openLinkedIn-C8D6FEADDF661722-3of4.csv openLinkedIn-C8D6FEADDF661722-4of4.csv > current-toplinked.csv

To find the new emails.

    $ java -jar toplinked-1.0.0-standalone.jar current-toplinked.csv current-linkedin.csv

### Installation

`toplinked` is available as a Maven artifact via [Clojars](httpd://clojars.org/org.clojars.blucas/blinkedin-connects).

## Versions

### 1.0.1

- Updated versions

### 1.0.0 

- Original version

## License

Distributed under the Eclipse Public License, the same as Clojure.
