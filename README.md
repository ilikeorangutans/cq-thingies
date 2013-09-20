# CQ Thingies

I've been working with [Adobe Experience Manager](http://www.adobe.com/solutions/web-experience-management.html)
(formerly Adobe CQ (formerly Day CQ)) for a while and there's a few smaller bits and pieces that made my life with CQ
easier. This project is an attempt to collect all the nice little utilities I wrote and add a few nicer ones.

## License

Licensed under [Apache License, Version 2](http://www.apache.org/licenses/LICENSE-2.0.html).

## Roadmap

- Add better parsys component that allows you to specify wrapping
- Add timed visibility tags and services to react to visibility events
- Add tags to limit visibility to specific device groups (think CQ mobile)

## Tag Libraries

There's a few tag libraries that make writing better user interfaces easier.

### Visibility Limiting

The tag library with the prefix ``only`` allows you to limit visibility of the wrapped content to a specific mode of the
CMS. For example:

    <%@ taglib prefix="only" uri="https://github.com/ilikeorangutans/cq-thingies/taglibs/only" %>

    <only:edit>
        <p>
            Helpful message for content editors. This will NOT show up in preview or on publish instances.
        </p>
    </only:edit>

    <only:design>
        <p>
            Another helpful message only visible in design mode, but not in preview or on publish instances.
        </p>
    </only:design>

    <only:runmodes runmodes="author,qa">
        <p>
            Message only visible in runmodes author or qa
        </p>
    </only:runmodes>
