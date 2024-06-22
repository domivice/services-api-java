package org.domivice.services.application.licences.commands;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.domivice.services.application.common.commands.BaseCommand;

import java.util.UUID;

@Data
@SuperBuilder
public class DeleteLicenceTypeCommand extends BaseCommand {
    private UUID commandId;
}
