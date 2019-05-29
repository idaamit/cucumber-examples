package com.example.with.expressions.steps;

import com.example.with.expressions.*;
import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterType;
import io.cucumber.cucumberexpressions.Transformer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableCellTransformer;
import io.cucumber.datatable.TableEntryTransformer;

import java.util.Locale;
import java.util.Map;

import static java.util.Locale.ENGLISH;

public class TypeRegistryConfiguration implements TypeRegistryConfigurer {

    @Override
    public Locale locale() {
        return ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineParameterType(new ParameterType<Integer>(
                "digit",
                "[0-9]",
                Integer.class,
                new Transformer<Integer>() {
                    @Override
                    public Integer transform(String s) throws Throwable {
                        return Integer.parseInt(s);
                    }
                })
        );

        typeRegistry.defineParameterType(new ParameterType<Color>(
                "color",           // name
                "RED|BLUE|YELLOW", // regexp
                Color.class,       // type
                new Transformer<Color>() {
                    @Override
                    public Color transform(String s) throws Throwable {
                        return Color.valueOf(s);
                    }
                })
        );
        typeRegistry.defineDataTableType(new DataTableType(
                Grocery.class,
                new TableEntryTransformer<Grocery>() {
                    @Override
                    public Grocery transform(Map<String, String> entry) {
                        return new Grocery(
                                entry.get("name"),
                                Integer.valueOf(entry.get("price"))
                        );
                    }
                }
        ));

        typeRegistry.defineParameterType(new ParameterType<JobResult>(
                "jobResult",           // name
                "COMPLETED|STARTED", // regexp
                JobResult.class,       // type
                new Transformer<JobResult>() {
                    @Override
                    public JobResult transform(String s) throws Throwable {
                        return JobResult.valueOf(s);
                    }
                })
        );
        typeRegistry.defineDataTableType(new DataTableType(JobType.class, new TableCellTransformer() {
            @Override
            public JobType transform(String cell) {
                return JobType.getByDescription(cell);
            }
        }));

        typeRegistry.defineDataTableType(new DataTableType(DbLine.class, new TableEntryTransformer<DbLine>() {
            @Override
            public DbLine transform(Map<String, String> entry) {
                return new DbLine(Integer.valueOf(entry.get("siteId")),
                        Long.parseLong(entry.get("interactionId")),
                        entry.get("contactGMTStartTimeAsString"),
                        Long.parseLong(entry.get("archiveId")),
                        entry.get("setNumber"),
                        (entry.get("iEsmDeviceID").equals("") ) ? null : Integer.valueOf(entry.get("iEsmDeviceID")),
                        entry.get("vcArchiveUniqueId"));
            }
        }));

    }
}