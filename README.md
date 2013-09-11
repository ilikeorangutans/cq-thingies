# CQ Thingies

I've been working with Adobe Experience Manager (formerly Adobe CQ (formerly Day CQ)) for a while and there's a few
smaller bits and pieces that made my life with CQ easier. This project is an attempt to collect all the nice little
utilities I wrote and add a few nicer ones.

## License

Licensed under Apache 2.

## Tag Libraries


There's a few tag libraries that make writing better user interfaces easier.

### Visibility Limiting

The tag library with the prefix ``only`` allows you to lmit visibility of the wrapped content to a specific mode of the
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
